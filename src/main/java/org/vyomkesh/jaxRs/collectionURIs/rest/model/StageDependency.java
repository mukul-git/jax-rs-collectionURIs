package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.Map;
import java.util.Objects;

public class StageDependency {
    long upstreamStageStepId;
    long downstreamStageStepId;
    Map<String, String> upstreamToDownstreamDepResourceNameMap;

    public StageDependency(long upstreamStageStepId, long downstreamStageStepId, Map<String, String> upstreamToDownstreamDepResourceNameMap) {
        this.upstreamStageStepId = upstreamStageStepId;
        this.downstreamStageStepId = downstreamStageStepId;
        this.upstreamToDownstreamDepResourceNameMap = upstreamToDownstreamDepResourceNameMap;
    }

    public long getUpstreamStageStepId() {
        return upstreamStageStepId;
    }

    public long getDownstreamStageStepId() {
        return downstreamStageStepId;
    }

    public Map<String, String> getUpstreamToDownstreamDepResourceNameMap() {
        return upstreamToDownstreamDepResourceNameMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StageDependency that = (StageDependency) o;
        return upstreamStageStepId == that.upstreamStageStepId &&
                downstreamStageStepId == that.downstreamStageStepId &&
                Objects.equals(upstreamToDownstreamDepResourceNameMap, that.upstreamToDownstreamDepResourceNameMap);
    }

    @Override
    public int hashCode() {

        return Objects.hash(upstreamStageStepId, downstreamStageStepId, upstreamToDownstreamDepResourceNameMap);
    }
}
