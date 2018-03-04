package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import com.google.common.graph.Network;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class StageStepsDependencyGraph implements Iterable<Network<Executable, ModelDependency>> /*//TODO: change to IterableNetwork extends Network implements Iterable*/ {
    private List<Stage> memberStages;
    private Network<Executable, ModelDependency> dependencyGraph;
    private StageDependencyDao stageDependencyDao;

    public StageStepsDependencyGraph(List<Stage> stages) {
        super();
        this.memberStages = stages;
        computeDependencyGraph();
    }

    public StageStepsDependencyGraph() {
        dependencyGraph = null; //TODO: use graph factory
    }

    private Network<Executable, ModelDependency> computeDependencyGraph() {
        //long modelStepId = 1L;
        //TODO: Check if parallel changes are threadsafe
        memberStages.parallelStream().forEach(stage -> {
            dependencyGraph.nodes().add(stage);
            stage.getStageSteps().parallelStream().forEach(modelStep -> {
                        dependencyGraph.nodes().add(modelStep);
                dependencyGraph.edges().add(new ModelDependency(stage.getId(), modelStep.getId(), Collections.EMPTY_MAP));
                List<ModelDependency> upstreamModelDependencies = stageDependencyDao.getUpstreamDepsFor(modelStep.getId());
                        upstreamModelDependencies.parallelStream().forEach(dependencyGraph.edges()::add);
                List<ModelDependency> downstreamModelDependencies = stageDependencyDao.getDownstreamDepsFor(modelStep.getId());
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

    public List<Stage> getMemberStages() {
        return Collections.unmodifiableList(memberStages);
    }


    public void setStageDependencyDao(StageDependencyDao stageDependencyDao) {
        this.stageDependencyDao = stageDependencyDao;
    }
}
