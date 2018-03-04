package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

//TODO: Introduce Iterable at later stage
//TODO: Change to Map<Long stepRunId, List<StageData>>
public interface Executable extends CompletionStage<Map<Long, List<StageData>>> /*, Iterable<Executable>*/ {


    //Add to input
    CompletableFuture<Map<Long, List<StageData>>> addToInput(Map<Long, List<StageData>> stageDataMap);

    //Add to output
    CompletableFuture<Map<Long, List<StageData>>> addToOutput(Map<Long, List<StageData>> stageDataMap);


    default CompletableFuture<Map<Long, List<StageData>>> execute(Map<Long, List<StageData>> inputData) {
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
        //trigger(null).thenAccept(stageDataMap -> stageResult.complete(output));
        //downstreamStages.parallelStream().forEach(executable -> executable.addToInput(output));

        return this.toCompletableFuture();
    }

    Map<Long, List<StageData>> getOutput();

    Map<Long, List<StageData>> getInput();

    CompletableFuture<Map<Long, List<StageData>>> getStageResult();

    CompletionStage<Map<Long, List<StageData>>> trigger(Void v);

    StageStepsDependencyGraph getDependencyGraph();

    List<Executable> getUpstreamStages();

    List<Executable> getDownstreamStages();

    default CompletableFuture<Map<Long, List<StageData>>> toCompletableFuture() {
        return getStageResult();
    }


    /*@Override
    Iterator<Executable> iterator();*/

    /*@Override
    default Spliterator<Executable> spliterator() {
        return null;
    }*/
}
