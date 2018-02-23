package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Model implements Executable {
    String name;
    long id;
    List<ModelStep> modelSteps;

    public Model(String name, long id, List<ModelStep> modelSteps) {
        this.name = name;
        this.id = id;
        this.modelSteps = modelSteps;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public List<ModelStep> getModelSteps() {
        return modelSteps;
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
