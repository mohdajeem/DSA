package Graph;
import java.util.*;

public class Revision1 {
    public static void main(String[] args) {
        System.out.println("-----------BFS------------");
        // create Adjacency Matrix for a Graph;
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter No. of Veritces for a Graph");
        // int vertices = sc.nextInt();
        // // int m = sc.nextInt();
        // int[][] adjMatrix = new int[vertices+1][vertices+1];
        // addEdges(adjMatrix, 0,2 );
        // addEdges(adjMatrix, 0,1 );
        // addEdges(adjMatrix, 1,2 );
        // addEdges(adjMatrix, 2,3 );
        // addEdges(adjMatrix, 2,4 );
        // addEdges(adjMatrix, 4,3 );

        // // print Graph 
        // System.out.println("print Graph");
        // for(int i = 0;i<vertices;i++){
        //     for(int j = 0; j<vertices;j++){
        //         System.out.print(adjMatrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // creating Adjacency list 
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i<5;i++){
            adjList.add(new ArrayList<>());
        }
        addEdgesList(adjList, 0,2 );
        addEdgesList(adjList, 0,1 );
        addEdgesList(adjList, 1,2 );
        addEdgesList(adjList, 2,3 );
        addEdgesList(adjList, 2,4 );
        addEdgesList(adjList, 4,3 );

        for(ArrayList<Integer> it : adjList){
            System.out.println(it);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[5];
        for(int i = 0;i<5;i++){
            if(visited[i] == false){
                bfs(adjList, visited, q, i);
            }
        }


    }

    public static void addEdges(int[][] adjMatrix, int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }
    public static void addEdgesList(ArrayList<ArrayList<Integer>> adjList, int i, int j){
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited,Queue<Integer> q, int stp){
        visited[stp] = true;
        q.add(stp);
        System.out.print(stp+" ");
        while(!q.isEmpty()){
            int n = q.poll();
            for(int it : adjList.get(n)){
                if(visited[it] == false){
                    visited[it] = true;
                    System.out.print(it+" ");
                    q.add(it);
                }
            }
        }
    }

}
