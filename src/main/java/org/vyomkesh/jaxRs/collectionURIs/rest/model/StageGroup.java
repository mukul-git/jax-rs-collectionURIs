package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class StageGroup extends AbstractExecutableStage {
    private long id;
    private String name;
    private List<Stage> stages;

    /*@Override
    public CompletableFuture<Map<Long, ModelData>> execute(Map<Long, ModelData> inputData) {
        CompletableFuture<Map<Long, ModelData>> future = new CompletableFuture<>();
        Iterator<Stage> itr = stages.iterator();
        while (itr.hasNext()) {
            // itr.next().execute(null).thenCompose(itr.next().execute(null));
        }
        // this.stages.forEach(model -> model.execute(null).thenCompose());

        return future;
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
        //TODO:
        return this;
    }



    /*@Override
    public Iterator<Executable> iterator() {
        return null;
    }*/
}
