package Graph;
import java.util.*;



public class NumberOfEnclaves {
    public static int noOfEnclaves(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        int[][] vis = new int[n][m];

        // Now I will traverse edge sections
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i==0 || j == 0 || i == n-1 || j == m-1){
                    if(mat[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        int[] drow = {0,-1,0,1};
        int[] dcol = {-1,0,1,0};
        while(!q.isEmpty()){
            // Pair p = q.remove();
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+drow[i];
                if(nrow >= 0 && nrow<n && ncol >= 0 && ncol < m 
                && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j] == 0 && mat[i][j] == 1){
                    count++;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }
        return count;

    }
    public static void main(String[] args) {
        int[][] mat = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                // if(i == 0 || i == n-1 || j == 0 || j == m-1){
                //     System.out.print(mat[i][j]+" ");
                // }
                System.out.print(mat[i][j]+" ");
            } 
            System.out.println();
        }
        System.out.println("----------------------------------");
        System.out.println("No. of enclaves in the mat : "+noOfEnclaves(mat));
    }

}

class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col=col;
    }
}
