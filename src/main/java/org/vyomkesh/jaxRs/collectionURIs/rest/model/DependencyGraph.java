/*
package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import com.google.common.graph.Network;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.core.util.UnmodifiableMultivaluedMap;

import javax.ws.rs.core.MultivaluedMap;
import java.util.*;
import java.util.function.Consumer;

public class DependencyGraph implements Iterable<Network<User, Integer>> {
    private Network<User, Integer> dependencyGraph;
    private MultivaluedMap<User, Map<User, Integer>> userMapMultivaluedMap;

    private DependencyGraph() {
    }

    public DependencyGraph(Network<User, Integer> dependencyGraph) {
        this.dependencyGraph = dependencyGraph;
        userMapMultivaluedMap = new MultivaluedMap<User, Map<User, Integer>>() {
            @Override
            public void putSingle(User key, Map<User, Integer> value) {

            }

            @Override
            public void add(User key, Map<User, Integer> value) {

            }

            @Override
            public Map<User, Integer> getFirst(User key) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public List<Map<User, Integer>> get(Object key) {
                return null;
            }

            @Override
            public List<Map<User, Integer>> put(User key, List<Map<User, Integer>> value) {
                return null;
            }

            @Override
            public List<Map<User, Integer>> remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends User, ? extends List<Map<User, Integer>>> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<User> keySet() {
                return null;
            }

            @Override
            public Collection<List<Map<User, Integer>>> values() {
                return null;
            }

            @Override
            public Set<Entry<User, List<Map<User, Integer>>>> entrySet() {
                return null;
            }
        }
    }

    @Override
    public Iterator<Network<User, Integer>> iterator() {
        return new NetworkIterator(dependencyGraph);
    }

    @Override
    public Spliterator<Network<User, Integer>> spliterator() {
        return null;
    }

    private static class NetworkIterator implements Iterator<Network<User, Integer>> {

        private Network<User, Integer> network;

        private NetworkIterator() {
        }

        public NetworkIterator(Network<User, Integer> network) {
            this.network = network;
        }


        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Network<User, Integer> next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }

    private static class NetworkSpliterator implements Spliterator<Network<User, Integer>> {

        private Network<User, Integer> network;
        private User rootNode;


        private NetworkSpliterator() {
        }

        public NetworkSpliterator(Network<User, Integer> network) {
            this.network = network;
            //find root Node
            network.nodes().forEach(user -> {
                if (network.predecessors(user).isEmpty()) {
                    this.rootNode = user;
                }
            });
        }


        @Override
        public boolean tryAdvance(Consumer<? super Network<User, Integer>> action) {
            return false;
        }

        @Override
        public Spliterator<Network<User, Integer>> trySplit() {
            network.nodes()
            return null;
        }

        @Override
        public long estimateSize() {
            return network.edges().size();
        }

        @Override
        public int characteristics() {
            return 0;
        }
    }
}
*/
