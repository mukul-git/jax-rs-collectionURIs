package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class Stage extends AbstractExecutableStage {
    String name;
    long id;
    List<StageStep> stageSteps;

    public Stage(String name, long id, List<StageStep> stageSteps) {
        this.name = name;
        this.id = id;
        this.stageSteps = stageSteps;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public List<StageStep> getStageSteps() {
        return stageSteps;
    }


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
    public CompletionStage<Map<Long, List<StageData>>> trigger(Void v) {

        return this;
    }

    /*@Override
    public Iterator<Executable> iterator() {
        return null;
    }*/
}
