import java.io.IOException;

public class main {
    public static void main(String args[]) {
        try {
            String filePath = "D:\\repository\\Kruskal\\example.txt";
            Graph g = new Graph(filePath);
            g.MST_Kruskal();
            g.showMST();;
        } catch (IOException e) {
            System.out.println("Wrong filePath");
        }
    }
}
