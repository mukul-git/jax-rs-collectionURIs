package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import com.google.common.graph.Network;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class StageStepsDependencyGraph implements Iterable<Network<Executable, StageDependency>> /*//TODO: change to IterableNetwork extends Network implements Iterable*/ {
    private List<Stage> memberStages;
    private Network<Executable, StageDependency> dependencyGraph;
    private StageDependencyDao stageDependencyDao;

    public StageStepsDependencyGraph(List<Stage> stages) {
        super();
        this.memberStages = stages;
        computeDependencyGraph();
    }

    public StageStepsDependencyGraph() {
        dependencyGraph = null; //TODO: use graph factory
    }

    private Network<Executable, StageDependency> computeDependencyGraph() {
        //long stageStepId = 1L;
        //TODO: Check if parallel changes are threadsafe
        memberStages.parallelStream().forEach(stage -> {
            dependencyGraph.nodes().add(stage);
            stage.getSubStages().parallelStream().forEach(stageStep -> {
                dependencyGraph.nodes().add(stageStep);
                dependencyGraph.edges().add(new StageDependency(stage.getId(), stageStep.getId(), Collections.EMPTY_MAP));
                List<StageDependency> upstreamStageDependencies = stageDependencyDao.getUpstreamDepsFor(stageStep.getId());
                upstreamStageDependencies.parallelStream().forEach(dependencyGraph.edges()::add);
                List<StageDependency> downstreamStageDependencies = stageDependencyDao.getDownstreamDepsFor(stageStep.getId());
                downstreamStageDependencies.parallelStream().forEach(dependencyGraph.edges()::add);
                    });
                }
        );


        return dependencyGraph;
    }

    @Override
    public Iterator<Network<Executable, StageDependency>> iterator() {
        return null;
    }

    @Override
    public Spliterator<Network<Executable, StageDependency>> spliterator() {
        return null;
    }

    public List<Stage> getMemberStages() {
        return Collections.unmodifiableList(memberStages);
    }


    public void setStageDependencyDao(StageDependencyDao stageDependencyDao) {
        this.stageDependencyDao = stageDependencyDao;
    }
}
