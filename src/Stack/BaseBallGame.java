package Stack;

import java.util.*;
public class BaseBallGame {
    public static void main(String[] args){
        String[] operations = {"5","2","C","D","+"};
        int result = calPoints(operations);
        System.out.print(result);

    }
    public static int calPoints(String[] operations){
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(5);
        st.push(10);
        int[] sum = new int[1];
        sumTwoVal(st, sum, 2);
        System.out.print
        return sum[0];

    }
    public static void sumTwoVal(Stack<Integer> st, int[] sum, int n){
        if(n == 0){
            return;
        }
        int val = st.pop();
        sum[0] += val;
        sumTwoVal(st, sum, n-1);
        st.push(val);
    }

}
