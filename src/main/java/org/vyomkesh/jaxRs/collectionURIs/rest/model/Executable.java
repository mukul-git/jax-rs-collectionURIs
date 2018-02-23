package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.CompletableFuture;

public interface Executable extends Iterable<Executable> {

    CompletableFuture<Map<Long, ModelData>> execute(Map<Long, ModelData> inputData);
    /*default Map<Long, ModelData> execute(CompletableFuture<Map<Long, ModelData>>... inputData){
        for()
    }*/

    ModelStepsDependencyGraph getDependencyGraph();

    List<Executable> getUpstream();

    List<Executable> getDownstream();

    @Override
    Iterator<Executable> iterator();

    @Override
    default Spliterator<Executable> spliterator() {
        return null;
    }
}
