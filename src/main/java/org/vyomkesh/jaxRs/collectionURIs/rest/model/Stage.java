package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class Stage extends AbstractExecutableStage {
    String name;
    long id;
    List<SubStage> subStages;

    public Stage(String name, long id, List<SubStage> subStages) {
        this.name = name;
        this.id = id;
        this.subStages = subStages;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public List<SubStage> getSubStages() {
        return subStages;
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
