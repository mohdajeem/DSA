package Graph;
import java.util.*;

public class Mapping {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap();
        mp.put(123, "English book");
        mp.put(133, "Mathematics book");
        mp.put(188, "DSA book for java");
        System.out.println(mp.get(123));
        mp.remove(123);
        System.out.println();

    }
}
