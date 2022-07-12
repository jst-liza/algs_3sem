class Edge {
    public int u, v, wgt;

    public Edge(int x, int y, int w) {
        this.u = x;
        this.v = y;
        this.wgt = w;
    }

    public void show() {
        System.out.print("Edge  [" + (char)(u + 64) + "]-(" + wgt + ")-[" + (char)(v + 64) + "]\n") ;
    }
}