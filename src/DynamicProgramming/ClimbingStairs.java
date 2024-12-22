package DynamicProgramming;
import java.util.*;

public class ClimbingStairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = countPaths(n);
        System.out.println("Ans : "+ans);

    }
    public static int countPaths(int n){
        if(n==1){
            return 1;
        } else if(n<0){
            return 0;
        }
        System.out.println("Hello "+n);
        int nm1 = countPaths(n-1);
        int nm2 = countPaths(n-2);
        int nm3 = countPaths(n-3);
        int cp = nm1+nm2+nm3;
        return cp;

    }

}
