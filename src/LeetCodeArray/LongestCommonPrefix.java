package LeetCodeArray;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        for(int i = 0;i<str.length;i++){
            System.out.print(str[i]+" ");
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<str.length;i++){
            if(str[i].length() < min){
                min = str[i].length();
            }
        }
        System.out.println(min);
        System.out.println("--------------------------------------------------");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<min;i++){
            char ch = str[0].charAt(i);
            boolean isCommon = true;
            for(int j = 1;j<str.length;j++){
                if(str[j].charAt(i) != ch){
                    isCommon = false;
                    break;
                }

            }
            if(isCommon){
                sb.append(ch);
            } else{
                break;
            }
            
            System.out.println();
            // System.out.print(str[i][0]+" ");
        }
        System.out.println(sb);
    }
}
