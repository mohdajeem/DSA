package DynamicProgramming;
import java.util.*;

public class ClimbingStairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = countPaths(n);
        System.out.println("Ans : "+ans);
        int ans2 = countsPathsDyn(n, new int[n+1]);
        System.out.println("ans2: "+ans2);


    }
    public static int countPaths(int n){
        if(n==1){
            return 1;
        } else if(n<0){
            return 0;
        }
        // System.out.println("Hello "+n);
        int nm1 = countPaths(n-1);
        int nm2 = countPaths(n-2);
        int nm3 = countPaths(n-3);
        int cp = nm1+nm2+nm3;
        return cp;

    }

    public static int countsPathsDyn(int n, int[] qb){
        if(n == 1){
            return 1;
        } else if(n<0){
            return 0;
        }

        if(qb[n] > 0){
            return qb[n];
        }
        int nm1 = countsPathsDyn(n-1, qb);
        int nm2 = countsPathsDyn(n-2, qb);
        int nm3 = countsPathsDyn(n-3, qb);
        int cp = nm1+nm2+nm3;
        qb[n] = cp;
        return cp;
    }
}
