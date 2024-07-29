import java.util.HashSet;
import java.util.Set;

public class UniqueArray {

    public static void main(String[] args) {

        int[] arr = {1, 3, 7, 24, 11, 9, 3};

        Set<Integer> uniqueSet  = new HashSet<>();

        for(int num : arr) {
            uniqueSet.add(num);
        }

        int uniqueArray[] = new int[uniqueSet.size()];

        int i = 0;

        for (int num : uniqueSet) {
             uniqueArray[i++] = num;
            }

        for (int num : uniqueArray) {
            System.out.print(num + " ");
        }
    }
}


