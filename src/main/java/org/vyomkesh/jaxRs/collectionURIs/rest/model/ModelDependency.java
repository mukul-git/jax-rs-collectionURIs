package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.Map;
import java.util.Objects;

public class ModelDependency {
    long upstreamModelStepId;
    long downstreamModelStepId;
    Map<String, String> upstreamToDownstreamDepResourceNameMap;

    public ModelDependency(long upstreamModelStepId, long downstreamModelStepId, Map<String, String> upstreamToDownstreamDepResourceNameMap) {
        this.upstreamModelStepId = upstreamModelStepId;
        this.downstreamModelStepId = downstreamModelStepId;
        this.upstreamToDownstreamDepResourceNameMap = upstreamToDownstreamDepResourceNameMap;
    }

    public long getUpstreamModelStepId() {
        return upstreamModelStepId;
    }

    public long getDownstreamModelStepId() {
        return downstreamModelStepId;
    }

    public Map<String, String> getUpstreamToDownstreamDepResourceNameMap() {
        return upstreamToDownstreamDepResourceNameMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelDependency that = (ModelDependency) o;
        return upstreamModelStepId == that.upstreamModelStepId &&
                downstreamModelStepId == that.downstreamModelStepId &&
                Objects.equals(upstreamToDownstreamDepResourceNameMap, that.upstreamToDownstreamDepResourceNameMap);
    }

    @Override
    public int hashCode() {

        return Objects.hash(upstreamModelStepId, downstreamModelStepId, upstreamToDownstreamDepResourceNameMap);
    }
}
