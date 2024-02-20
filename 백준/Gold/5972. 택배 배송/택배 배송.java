import java.io.*;
import java.util.*;

public class Main {
	static List<List<Node>> graph = new ArrayList<>();
	static int V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, weight));
			graph.get(end).add(new Node(start, weight));
		}

		Dijkstra(0);
	}

	private static void Dijkstra(int index) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] distance = new int[V];

		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[index] = 0;
		pq.offer(new Node(index, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int nodeIndex = node.index;
			int weight = node.weight;
			if (weight > distance[nodeIndex]) {
				continue;
			}

			for (Node linkedNode : graph.get(nodeIndex)) {
				if (weight + linkedNode.weight < distance[linkedNode.index]) {
					distance[linkedNode.index] = weight + linkedNode.weight;
					pq.offer(new Node(linkedNode.index, distance[linkedNode.index]));
				}
			}
		}
		System.out.println(distance[V - 1]);
	}

	static class Node implements Comparable<Node> {
		private int index;
		private int weight;

		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}