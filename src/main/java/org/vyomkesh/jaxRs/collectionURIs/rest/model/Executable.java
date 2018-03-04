package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

//TODO: Introduce Iterable at later stage
//TODO: Change to Map<Long stepRunId, List<ModelData>>
public interface Executable extends CompletionStage<Map<Long, List<ModelData>>> /*, Iterable<Executable>*/ {


    //Add to input
    CompletableFuture<Map<Long, List<ModelData>>> addToInput(Map<Long, List<ModelData>> modelDataMap);

    //Add to output
    CompletableFuture<Map<Long, List<ModelData>>> addToOutput(Map<Long, List<ModelData>> modelDataMap);


    default CompletableFuture<Map<Long, List<ModelData>>> execute(Map<Long, List<ModelData>> inputData) {
        List<Executable> upstreamStages = getUpstreamStages();
        //List<Executable> downstreamStages = getDownstreamStages();

        upstreamStages.parallelStream()
                .forEach(executable -> {
                    executable.thenComposeAsync(this::addToInput);
                });
        CompletableFuture<Void> allUpstreamStages = CompletableFuture.allOf(upstreamStages.toArray(new CompletableFuture[upstreamStages.size()]));
        allUpstreamStages
                .thenComposeAsync(this::trigger)
                .thenComposeAsync(t -> {
                    toCompletableFuture().complete(getOutput());
                    return this.toCompletableFuture();
                });
        /*allUpstreamHoses.thenApply(
                v -> upstreamHoses.stream()
                        .map(executable -> executable.toCompletableFuture().join())
                        .collect(Collectors.toList()));*/
        //trigger(null).thenAccept(modelDataMap -> stageResult.complete(output));
        //downstreamStages.parallelStream().forEach(executable -> executable.addToInput(output));

        return this.toCompletableFuture();
    }

    Map<Long, List<ModelData>> getOutput();

    Map<Long, List<ModelData>> getInput();

    CompletableFuture<Map<Long, List<ModelData>>> getStageResult();

    CompletionStage<Map<Long, List<ModelData>>> trigger(Void v);

    StageStepsDependencyGraph getDependencyGraph();

    List<Executable> getUpstreamStages();

    List<Executable> getDownstreamStages();

    default CompletableFuture<Map<Long, List<ModelData>>> toCompletableFuture() {
        return getStageResult();
    }


    /*@Override
    Iterator<Executable> iterator();*/

    /*@Override
    default Spliterator<Executable> spliterator() {
        return null;
    }*/
}
