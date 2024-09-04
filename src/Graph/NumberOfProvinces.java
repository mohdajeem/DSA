package Graph;
import java.util.*;

public class NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println("hello world");

        List<ArrayList<Integer>> adjL = new ArrayList<>();
        adjL.add(new ArrayList<>());
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        adjL.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        adjL.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        adjL.add(list3);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(5);
        adjL.add(list4);
        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(4);
        list5.add(6);
        adjL.add(list5);
        ArrayList<Integer> list6 = new ArrayList<>();
        list6.add(5);
        adjL.add(list6);
        ArrayList<Integer> list7 = new ArrayList<>();
        list7.add(8);
        adjL.add(list7);
        ArrayList<Integer> list8 = new ArrayList<>();
        list8.add(7);
        adjL.add(list8);
        // print list of list 
        // for(ArrayList<Integer> lt : adjL){
        //     System.out.println(lt);
        // }
        int n = 8;
        boolean[] vis = new boolean[n+1];
        int provinces = noOfProvince(adjL, vis, n);
        System.out.println(provinces);

    }
    private static void bfs(List<ArrayList<Integer>> adjL, int strPoint, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();;
        q.add(strPoint);
        vis[strPoint] = true;
        while(!q.isEmpty()){
            int n = q.poll();
            for(int it : adjL.get(n)){
                if(vis[it] == false){
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
    }
    private static int noOfProvince(List<ArrayList<Integer>> adjL, boolean[] vis, int n){
        int c = 0;
        for(int i = 1;i<=n;i++){
            if(vis[i]== false){
                bfs(adjL, i, vis);
                c++;
            }
        }
        return c;
    }
}
