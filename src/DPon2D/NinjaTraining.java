package DPon2D;
import java.util.*;
public class NinjaTraining {
    public static void main(String[] args) {
        
        int[][] arr = {
            {10,50,5},
            {25,100,32},
            {12,11,100}
        };
        int result = maxPoints(arr.length-1, 3, arr);
        System.out.println(result);
        int[][] dp = new int[arr.length][4];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        int dpResult = maxPointsDp(arr.length-1, 3, arr, dp);
        System.out.println(dpResult);


        // using tabluation we will solve this question 
        int tabRes = maxProfitTab(arr);
        System.out.println(tabRes);// it quite faster
        // time complexity - O(n*4*3);
        // space complexity - O(n*4) + O(n); 


        int optRes = maxProfitOpt(arr);
        System.out.println(optRes);
    }




    // maxProfit - Optimized Approach;

    public static int maxProfitOpt(int[][] arr){
        int n = arr.length;
        // generally we only need two array - one is the previous which will be used for to fill our current array
        int[] prev = new int[4];
        int[] curr = new int[4];
        // replace every dp[0] with the prev;
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0],arr[0][2]);
        prev[2] = Math.max(arr[0][0],arr[0][1]);
        prev[3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));

        for(int day = 1; day<n;day++){
            int[] temp = new int[4];
            for(int last = 0;last<4;last++){
                temp[last]=0;
                for(int task = 0;task<3;task++){
                    if(task != last){
                        int point = arr[day][task] + prev[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }

    // by Tabluation 
    public static int maxProfitTab(int[][] arr){
        int n = arr.length;
        int[][] dp = new int[n][4];
        // base case 
        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][0],arr[0][1]);
        dp[0][3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        // base case complete 

        for(int day = 1; day < n;day++){
            int[] temp = new int[4];
            for(int last = 0;last < 4;last++){
                temp[last] = 0;
                for(int task = 0;task<3;task++){
                    // copy paste the recursion 
                    if(task != last){
                        int point = arr[day][task] + dp[day-1][task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
                dp[day][last] = temp[last];
            }
        }

        return dp[n-1][3];
    }

    // Using Memoization
    public static int maxPointsDp(int day, int last, int[][] arr, int[][] dp){
        if(day == 0){
            int maxi = 0;
            for(int i = 0;i<3;i++){
                if(i != last){
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int maxi = 0;
        for(int i =0;i<3;i++){
            if(i!=last){
                int points = arr[day][i] + maxPointsDp(day-1, i, arr, dp);
                maxi = Math.max(maxi, points);
            }
        }
        return dp[day][last] = maxi;

    }
    public static int maxPoints(int day, int last, int[][] arr){
        //  base case
        if(day == 0){
            int maxi = 0;
            for(int i =0;i<3;i++){
                if(i != last){
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }
        int maxi = 0;
        for(int i = 0;i<3;i++){
            if(i != last){
                int points = arr[day][i]+maxPoints(day-1, i, arr);
                maxi = Math.max(maxi,points);
            }
        }
        return maxi;
    }
}
