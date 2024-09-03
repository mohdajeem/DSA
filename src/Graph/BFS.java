package Graph;
import java.util.*;

public class BFS {
    private int[][] adjMatrix;
    private  void createAdjMatrix(int n, int m){
        adjMatrix = new int[n+1][n+1];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adjMatrix[x][y] = 1;
            adjMatrix[y][x] = 1;
        }
        sc.close();
    }

    private List<ArrayList<Integer>> addAdjList(int n, int m){
        List<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            ans.add(new ArrayList<>());
        }
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            ans.get(x).add(y);
            ans.get(y).add(x);
        }
        return ans;
    }
    public void printMatrix(int n){
        for(int i = 0;i<=n;i++){
            for(int j = 0; j<=n;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        BFS graph = new BFS();
        System.out.println("Welcome to Graph");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Vertices and Edges : ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<ArrayList<Integer>> list = graph.addAdjList(n, m);
        for(ArrayList<Integer> it : list){
            System.out.println(it);
        }
        graph.bfs(list, 1, n);
        System.out.println();
        graph.bfs(list, 3, n);
        System.out.println();
        boolean[] vis = new boolean[n+1];
        graph.dfs(list, 1, n, vis);
    }

    private void bfs(List<ArrayList<Integer>> adjL, int firstVal, int vertices){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[vertices+1];
        vis[firstVal] = true;
        q.add(firstVal);
        while(!q.isEmpty()){
            int v = q.poll();
            System.out.print(v+" ");
            for(int lt : adjL.get(v)){
                if(vis[lt] == false){
                    q.add(lt);
                    vis[lt] = true;
                }
            }
        }
    }
    private void dfs(List<ArrayList<Integer>> adjL, int strPoint, int vertices, boolean[] vis){
        vis[strPoint] = true;
        System.out.print(strPoint+" ");
        for(int lt : adjL.get(strPoint)){
            if(vis[lt] == false){
                dfs(adjL, lt, vertices, vis);
            }
        }
    }

}
