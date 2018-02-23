package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModelGroup implements Executable {
    private long id;
    private String name;
    private List<Model> models;

    @Override
    public CompletableFuture<Map<Long, ModelData>> execute(Map<Long, ModelData> inputData) {
        CompletableFuture<Map<Long, ModelData>> future = new CompletableFuture<>();
        Iterator<Model> itr = models.iterator();
        while (itr.hasNext()) {
            // itr.next().execute(null).thenCompose(itr.next().execute(null));
        }
        // this.models.forEach(model -> model.execute(null).thenCompose());

        return future;
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
