package LeetCodeArray;

public class RemoveElements {
    public static void main(String[] args) {
        System.out.println("This is leetcode Array problem");
        int[] arr = {3,2,2,3};
        int i = 0;
        int j = 1;
        while(i<=j && j<arr.length){
            if(arr[i] == 3){
                if(arr[i] != arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                } else{
                    j++;
                }
            } else{
                i++;
                j++;
            }
        }
        for(int k = 0;k<arr.length;k++){
            System.out.print(arr[k]+" ");
        }
        // for(int i = 0;i<arr.length;i++){
        //     if(arr[i]==3){
        //         System.out.print(i+" ");
        //     }
        // }
    }
}
