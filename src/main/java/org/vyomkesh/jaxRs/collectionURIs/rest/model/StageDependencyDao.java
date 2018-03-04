package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.ArrayList;
import java.util.List;

public class StageDependencyDao {


    public List<StageDependency> getUpstreamDepsFor(long stageStepId) {
        return new ArrayList<>();
    }

    public List<StageDependency> getDownstreamDepsFor(long stageStepId) {
        return new ArrayList<>();
    }
}
