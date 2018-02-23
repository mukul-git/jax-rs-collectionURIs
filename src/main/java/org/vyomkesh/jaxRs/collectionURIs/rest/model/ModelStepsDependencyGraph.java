package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import com.google.common.graph.Network;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class ModelStepsDependencyGraph implements Iterable<Network<Executable, ModelDependency>> {
    private List<Model> memberModels;
    private Network<Executable, ModelDependency> dependencyGraph;
    private ModelDependencyDao modelDependencyDao;

    public ModelStepsDependencyGraph(List<Model> models) {
        this.memberModels = models;
        computeDependencyGraph();
    }

    private Network<Executable, ModelDependency> computeDependencyGraph() {
        //long modelStepId = 1L;
        //TODO: Check if parallel changes are threadsafe
        memberModels.parallelStream().forEach(model -> {
                    dependencyGraph.nodes().add(model);
                    model.getModelSteps().parallelStream().forEach(modelStep -> {
                        dependencyGraph.nodes().add(modelStep);
                        dependencyGraph.edges().add(new ModelDependency(model.getId(), modelStep.getId(), Collections.EMPTY_MAP));
                        List<ModelDependency> upstreamModelDependencies = modelDependencyDao.getUpstreamDepsFor(modelStep.getId());
                        upstreamModelDependencies.parallelStream().forEach(dependencyGraph.edges()::add);
                        List<ModelDependency> downstreamModelDependencies = modelDependencyDao.getDownstreamDepsFor(modelStep.getId());
                        downstreamModelDependencies.parallelStream().forEach(dependencyGraph.edges()::add);
                    });
                }
        );


        return dependencyGraph;
    }

    @Override
    public Iterator<Network<Executable, ModelDependency>> iterator() {
        return null;
    }

    @Override
    public Spliterator<Network<Executable, ModelDependency>> spliterator() {
        return null;
    }

    public List<Model> getMemberModels() {
        return Collections.unmodifiableList(memberModels);
    }


}
