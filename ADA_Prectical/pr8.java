import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class KruskalAlgorithm {

    int V = 4, E = 5;

    int find(int parent[], int i) {
        if (parent[i] == i) return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskalMST(Edge edges[]) {
        Arrays.sort(edges);
        int parent[] = new int[V];

        for (int i = 0; i < V; i++)
            parent[i] = i;

        for (Edge edge : edges) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if (x != y) {
                System.out.println(edge.src + " - " + edge.dest);
                union(parent, x, y);
            }
        }
    }

    public static void main(String[] args) {
        Edge edges[] = new Edge[5];

        for (int i = 0; i < 5; i++) edges[i] = new Edge();

        edges[0].src=0; edges[0].dest=1; edges[0].weight=10;
        edges[1].src=0; edges[1].dest=2; edges[1].weight=6;
        edges[2].src=0; edges[2].dest=3; edges[2].weight=5;
        edges[3].src=1; edges[3].dest=3; edges[3].weight=15;
        edges[4].src=2; edges[4].dest=3; edges[4].weight=4;

        new KruskalAlgorithm().kruskalMST(edges);
    }
}
