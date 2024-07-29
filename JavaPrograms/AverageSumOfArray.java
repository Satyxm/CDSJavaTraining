public class AverageSumOfArray{

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 8};
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++){
            sum = sum + arr[i];
        }
        System.out.println("Sum of Array: " + sum);
        float average =  (float) sum / n;
        System.out.println("Average of Sum Array: " + average);
    }
}
