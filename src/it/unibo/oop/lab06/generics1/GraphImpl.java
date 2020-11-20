/**
 * 
 */
package it.unibo.oop.lab06.generics1;

import java.util.*;

public class GraphImpl<N> implements Graph<N> {
	
	private final Map<N, Set<N>> map = new HashMap<>();

	@Override
	public void addNode(final N node) {
		map.put(node, new HashSet<>());
	}

	@Override
	public void addEdge(final N source, final N target) {
		final Set<N> sourceAdj = map.get(source);
		final Set<N> targetAdj = map.get(target);
		if (sourceAdj != null && targetAdj != null) {
			sourceAdj.add(target);
			targetAdj.add(source);
		}
	}

	@Override
	public Set<N> nodeSet() {
		return map.keySet();
	}

	@Override
	public Set<N> linkedNodes(N node) {
		final Set<N> setLinkedNodes = map.get(node);
		if (setLinkedNodes == null) {
			return Collections.emptySet();
		}
		return setLinkedNodes;
	}

	@Override
	public List<N> getPath(N source, N target) {
		// TODO Auto-generated method stub
		return null;
	}

}
