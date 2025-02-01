package DPonGrids;

import java.util.*;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] arr = {
            {5,9,6},
            {11,5,2}
        };
        int ans = minPathSum(arr);
        System.out.println(ans);
        
    }

    public static int minPathSum(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        
        // return minRec(m-1,n-1,arr);
        /* 
        int[][] dp = new int[m][n];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return minMemo(m-1, n-1, arr, dp);
        */
        // return minTab(m, n, arr); // working fine - fully working

        return optMin(m, n, arr); // full working

    }

    // lets optimize it 
    public static int optMin(int m, int n, int[][] arr){
        int[] prev = new int[n];
        int[] curr = new int[n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0){
                    curr[j] = arr[i][j];
                } else{
                    int up = Integer.MAX_VALUE;
                    if(i>0) up = prev[j];
                    int left = Integer.MAX_VALUE;
                    if(j>0) left =curr[j-1];
                    curr[j] = arr[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }


    // lets in tabular form
    public static int minTab(int m,int n, int[][] arr){
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = arr[i][j];
                } else{
                    int up = Integer.MAX_VALUE;
                    if(i>0) up = dp[i-1][j];
                    int left = Integer.MAX_VALUE;
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = arr[i][j] + Math.min(up, left);
                }
            }
        }

        return dp[m-1][n-1];
    }

    // lets memoize it
    public static int minMemo(int i, int j, int[][] arr, int[][] dp){
        if(i == 0 && j == 0) return arr[i][j];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1) return dp[i][j];
        int up = minMemo(i-1, j, arr, dp);
        int left = minMemo(i, j-1, arr, dp);

        return dp[i][j] = arr[i][j] + Math.min(up,left);
    }

    // Try by recursion
    public static int minRec(int i, int j, int[][] arr){
        if(i == 0 && j == 0) return arr[0][0];
        if(i< 0 || j<0) return Integer.MAX_VALUE;
        int up =  minRec(i-1,j,arr);
        int left = minRec(i,j-1,arr);

        return arr[i][j] + Math.min(up, left);
    }
}
