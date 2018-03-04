package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public abstract class AbstractExecutableStage extends CompletableFuture<Map<Long, List<StageData>>> implements Executable {
    private CompletableFuture<Map<Long, List<StageData>>> stageResult = new CompletableFuture<>();
    private Map<Long, List<StageData>> input = new HashMap<>();
    private Map<Long, List<StageData>> output = new HashMap<>();


    //Add to input
    public CompletableFuture<Map<Long, List<StageData>>> addToInput(Map<Long, List<StageData>> stageDataMap) {
        //TODO:
        input.putIfAbsent(1L, new ArrayList<>());
        return null;
    }

    //Add to output
    public CompletableFuture<Map<Long, List<StageData>>> addToOutput(Map<Long, List<StageData>> stageDataMap) {
        //TODO:
        output.putIfAbsent(1L, new ArrayList<>());
        return null;
    }

    @Override
    public Map<Long, List<StageData>> getOutput() {
        return output;
    }

    @Override
    public Map<Long, List<StageData>> getInput() {
        return input;
    }

    @Override
    public CompletableFuture<Map<Long, List<StageData>>> getStageResult() {
        return stageResult;
    }

    public abstract CompletionStage<Map<Long, List<StageData>>> trigger(Void v);/* {
        //TODO: Trigger this stage run
        //TODO: persist data, then
        addToOutput(new HashMap<>());
        return this;
    }*/

}
