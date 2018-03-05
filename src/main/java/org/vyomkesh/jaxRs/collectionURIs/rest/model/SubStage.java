package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class SubStage extends AbstractExecutableStage {
    private long stageId;
    private long id;
    private String name;

    public SubStage(long stageId, long id, String name) {
        this.stageId = stageId;
        this.id = id;
        this.name = name;
    }

    public long getStageId() {
        return stageId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*@Override
    public CompletableFuture<Map<Long, StageData>> execute(Map<Long, StageData> inputData) {
        return null;
    }*/


    @Override
    public CompletionStage<Map<Long, List<StageData>>> trigger(Void v) {
        return this;
    }
}
