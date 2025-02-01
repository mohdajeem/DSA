package DPonGrids;

import java.util.*;

public class UniquePaths{
    public static void main(String[] args){
    
        // count unique paths using recursion - 
        // TC-O(2^(m*n)) SC - O(sum of paths)
        // 4*4 matrix
        int count = uniquePathsRec(3,3);
        System.out.println(count);

        // 4*4 for using memoisatoin;
        int memoC = memoUniquePaths(4, 4);
        System.out.println(memoC);

        // 4*4 for using tabluation
        int tebC = tabUniquePaths(4, 4);
        System.out.println(tebC);

    }

    // unique paths using tabluation 
    public static int tabUniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i ==0 && j == 0){
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0;
                if(i >0) up = dp[i-1][j];
                int left = 0;
                if(j > 0) left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }

    // unique paths using memoisaton 
    public static int memoUniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return memoRec(m-1,n-1,dp);

    }
    public static int memoRec(int i, int j, int[][] dp){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        
        int up = memoRec(i-1, j, dp);
        int left = memoRec(i,j-1, dp);
        return dp[i][j] = up+left;
    }

    // unique paths by using Recursion 

    public static int uniquePathsRec(int m, int n){
        /*
         * base case 
         * either we reached our destination
         * or we will not - when we will go out of bounds
         */
        // we reached our destination
        if(m == 0 && n == 0){
            return 1;
        }
        // we can't reach our destination
        if(m < 0 || n < 0) return 0;
        int up = uniquePathsRec(m-1, n);
        int left = uniquePathsRec(m,n-1);

        return up+left;
    }
}