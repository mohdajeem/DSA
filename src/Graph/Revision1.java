package Graph;
import java.util.*;

public class Revision1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // create Adjacency Matrix for a Graph;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. of Veritces for a Graph");
        int vertices = sc.nextInt();
        // int m = sc.nextInt();
        int[][] adjMatrix = new int[vertices+1][vertices+1];
        addEdges(adjMatrix, 0,2 );
        addEdges(adjMatrix, 0,1 );
        addEdges(adjMatrix, 1,2 );
        addEdges(adjMatrix, 2,3 );
        addEdges(adjMatrix, 2,4 );
        addEdges(adjMatrix, 4,3 );

        // print Graph 
        System.out.println("print Graph");
        for(int i = 0;i<vertices;i++){
            for(int j = 0; j<vertices;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void addEdges(int[][] adjMatrix, int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

}
