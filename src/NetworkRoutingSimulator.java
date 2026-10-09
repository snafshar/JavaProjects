import java.util.*;

public class NetworkRoutingSimulator {
    static class Edge {
        final int to, cost;
        Edge(int to, int cost) { this.to = to; this.cost = cost; }
    }

    static int[] dijkstra(List<Edge>[] graph, int source) {
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        PriorityQueue<int[]> queue =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{source, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            if (current[1] != distance[node]) continue;

            for (Edge edge : graph[node]) {
                int candidate = distance[node] + edge.cost;
                if (candidate < distance[edge.to]) {
                    distance[edge.to] = candidate;
                    queue.add(new int[]{edge.to, candidate});
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        final int nodes = 20;
        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new List[nodes];
        for (int i = 0; i < nodes; i++) graph[i] = new ArrayList<>();

        Random random = new Random(42);
        for (int i = 0; i < 60; i++) {
            int a = random.nextInt(nodes);
            int b = random.nextInt(nodes);
            if (a != b) {
                int cost = 1 + random.nextInt(20);
                graph[a].add(new Edge(b, cost));
                graph[b].add(new Edge(a, cost));
            }
        }

        System.out.println("Shortest network costs from node 0:");
        System.out.println(Arrays.toString(dijkstra(graph, 0)));
    }
}
