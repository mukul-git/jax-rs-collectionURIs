package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.ArrayList;
import java.util.List;

public class StageDependencyDao {


    public List<ModelDependency> getUpstreamDepsFor(long modelStepId) {
        return new ArrayList<>();
    }

    public List<ModelDependency> getDownstreamDepsFor(long modelStepId) {
        return new ArrayList<>();
    }
}
