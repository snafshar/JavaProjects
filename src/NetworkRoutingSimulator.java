import java.util.*;

public class NetworkRoutingSimulator {
    record Edge(int to,int cost) {}
    static int[] dijkstra(List<Edge>[] graph,int source){
        int[] distance=new int[graph.length]; Arrays.fill(distance,Integer.MAX_VALUE); distance[source]=0;
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a->a[1])); queue.add(new int[]{source,0});
        while(!queue.isEmpty()){ int[] cur=queue.poll(); int node=cur[0]; if(cur[1]!=distance[node]) continue;
            for(Edge edge:graph[node]){ int candidate=distance[node]+edge.cost(); if(candidate<distance[edge.to()]){distance[edge.to()]=candidate; queue.add(new int[]{edge.to(),candidate});}}
        } return distance;
    }
    static void addUndirectedEdge(List<Edge>[] graph,int a,int b,int cost){graph[a].add(new Edge(b,cost));graph[b].add(new Edge(a,cost));}
    static double averageReachableCost(int[] distance){long sum=0;int count=0;for(int d:distance)if(d<Integer.MAX_VALUE){sum+=d;count++;}return count==0?Double.POSITIVE_INFINITY:(double)sum/count;}
    public static void main(String[] args){
        final int nodes=20;
        @SuppressWarnings("unchecked") List<Edge>[] graph=new List[nodes];
        for(int i=0;i<nodes;i++)graph[i]=new ArrayList<>();
        Random random=new Random(42);
        for(int i=0;i<60;i++){int a=random.nextInt(nodes),b=random.nextInt(nodes);if(a!=b)addUndirectedEdge(graph,a,b,1+random.nextInt(20));}
        int[] distance=dijkstra(graph,0);
        System.out.println("Shortest network costs from node 0:");
        for(int i=0;i<distance.length;i++)System.out.printf("0 -> %d: %s%n",i,distance[i]==Integer.MAX_VALUE?"unreachable":distance[i]);
        System.out.printf("Average reachable cost: %.2f%n",averageReachableCost(distance));
    }
}
