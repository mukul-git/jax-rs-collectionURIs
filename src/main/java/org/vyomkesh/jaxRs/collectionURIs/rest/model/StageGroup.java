package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class StageGroup extends AbstractExecutableStage {
    private long id;
    private String name;
    private List<Stage> stages;

    /*@Override
    public CompletableFuture<Map<Long, StageData>> execute(Map<Long, StageData> inputData) {
        CompletableFuture<Map<Long, StageData>> future = new CompletableFuture<>();
        Iterator<Stage> itr = stages.iterator();
        while (itr.hasNext()) {
            // itr.next().execute(null).thenCompose(itr.next().execute(null));
        }
        // this.stages.forEach(stage -> stage.execute(null).thenCompose());

        return future;
    }*/

    @Override
    public CompletionStage<Map<Long, List<StageData>>> trigger(Void v) {
        //TODO:
        return this;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Stage> getStages() {
        return stages;
    }



    /*@Override
    public Iterator<Executable> iterator() {
        return null;
    }*/
}
