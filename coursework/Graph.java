import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Graph {
    private int V, E;
    private Edge[] edge;
    private Edge[] mst;

    public Graph(String graphFile) throws IOException {
        int u, v;
        int w, e;

        FileReader fr = new FileReader(graphFile);
        BufferedReader reader = new BufferedReader(fr);

        String line = reader.readLine();
        String[] parts = line.split(" ");
        V = Integer.parseInt(parts[0]);
        E = Integer.parseInt(parts[1]);
        System.out.println("\nVertices = " + parts[0] + " Edges = " + parts[1] + "\n");

        edge = new Edge[E+1];
        System.out.println("[Node]--Weight--[Node]");
        for (e = 1; e <= E; ++e) {
            line = reader.readLine();
            parts = line.split(" ");
            u = (int)(parts[0].charAt(0))-64;
            v = (int)(parts[1].charAt(0))-64;
            w = Integer.parseInt(parts[2]);
            System.out.println("[" + (char)(u + 64) + "]--" + w + "--[" + (char)(v + 64) + "]");
            edge[e] = new Edge(u, v, w);
        }
        System.out.println("\n");
    }

    public Edge[] MST_Kruskal() {
        int ei, i = 0;
        Edge e;
        int uSet, vSet;
        int totalWeight = 0;
        unionSets partition;

        mst = new Edge[V-1];
        Heap h = new Heap(E, edge);
        partition = new unionSets(V);
        partition.showSets();

        while(i < V - 1) {
            ei = h.remove();
            e = edge[ei];
            uSet = partition.findSet(e.u);
            vSet = partition.findSet(e.v);

            if(uSet != vSet) {
                mst[i] = e;
                ++i;
                System.out.print("\n" + i + ": ");
                e.show();
                partition.union(uSet, vSet);
                partition.showSets();
                totalWeight += e.wgt;
            }
        }
        System.out.println("\nWeight of MST is: " + totalWeight );
        return mst;
    }

    public void showMST() {
        System.out.print("Minimum spanning tree:\n");
        for(int e = 0; e < V-1; ++e)
            mst[e].show();
    }
}