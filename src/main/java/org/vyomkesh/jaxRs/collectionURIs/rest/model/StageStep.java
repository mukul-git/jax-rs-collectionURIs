package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class StageStep extends AbstractExecutableStage {
    private long modelId;
    private long id;
    private String name;

    public StageStep(long modelId, long id, String name) {
        this.modelId = modelId;
        this.id = id;
        this.name = name;
    }

    public long getModelId() {
        return modelId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*@Override
    public CompletableFuture<Map<Long, ModelData>> execute(Map<Long, ModelData> inputData) {
        return null;
    }*/

    @Override
    public StageStepsDependencyGraph getDependencyGraph() {
        return null;
    }

    @Override
    public List<Executable> getUpstreamStages() {
        return null;
    }

    @Override
    public List<Executable> getDownstreamStages() {
        return null;
    }


    @Override
    public CompletionStage<Map<Long, List<ModelData>>> trigger(Void v) {
        return this;
    }
}
