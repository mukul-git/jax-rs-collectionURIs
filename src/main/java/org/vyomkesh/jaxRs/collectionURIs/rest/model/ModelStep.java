package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModelStep implements Executable {
    private long modelId;
    private long id;
    private String name;

    public ModelStep(long modelId, long id, String name) {
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

    @Override
    public CompletableFuture<Map<Long, ModelData>> execute(Map<Long, ModelData> inputData) {
        return null;
    }

    @Override
    public ModelStepsDependencyGraph getDependencyGraph() {
        return null;
    }

    @Override
    public List<Executable> getUpstream() {
        return null;
    }

    @Override
    public List<Executable> getDownstream() {
        return null;
    }

    @Override
    public Iterator<Executable> iterator() {
        return null;
    }
}
