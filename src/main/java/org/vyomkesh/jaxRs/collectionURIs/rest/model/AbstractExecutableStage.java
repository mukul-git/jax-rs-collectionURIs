package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public abstract class AbstractExecutableStage extends CompletableFuture<Map<Long, List<ModelData>>> implements Executable {
    private CompletableFuture<Map<Long, List<ModelData>>> stageResult = new CompletableFuture<>();
    private Map<Long, List<ModelData>> input = new HashMap<>();
    private Map<Long, List<ModelData>> output = new HashMap<>();


    //Add to input
    public CompletableFuture<Map<Long, List<ModelData>>> addToInput(Map<Long, List<ModelData>> modelDataMap) {
        //TODO:
        input.putIfAbsent(1L, new ArrayList<>());
        return null;
    }

    //Add to output
    public CompletableFuture<Map<Long, List<ModelData>>> addToOutput(Map<Long, List<ModelData>> modelDataMap) {
        //TODO:
        output.putIfAbsent(1L, new ArrayList<>());
        return null;
    }

    @Override
    public Map<Long, List<ModelData>> getOutput() {
        return output;
    }

    @Override
    public Map<Long, List<ModelData>> getInput() {
        return input;
    }

    @Override
    public CompletableFuture<Map<Long, List<ModelData>>> getStageResult() {
        return stageResult;
    }

    public abstract CompletionStage<Map<Long, List<ModelData>>> trigger(Void v);/* {
        //TODO: Trigger this stage run
        //TODO: persist data, then
        addToOutput(new HashMap<>());
        return this;
    }*/

}
