package Graph;

public class GraphRepresentation {
    private int[][] adjMatrix;
    private int vertices;

    // constructor 
    public GraphRepresentation(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // adding edge
    public void addEdge(int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    // print graph
    public void printEdge(){
        for(int i = 0; i<vertices; i++){
            for(int j = 0; j<vertices;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("this is my starting of java Graph DSA");
        GraphRepresentation g = new GraphRepresentation(4);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(3, 2);
        g.addEdge(3, 0);
        g.printEdge();
    }

}
