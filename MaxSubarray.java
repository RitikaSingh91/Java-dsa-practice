import java.util.ArrayList;

public class MaxSubarray {

    static long maxSubarray(int k, ArrayList<Integer> arr) {

        int n = arr.size();

        long maxSum = 0;
        long sum = 0;

        int index = 0;

        // First window sum
        while (index < n && index < k) {
            sum += arr.get(index);
            index++;
        }

        maxSum = sum;

        // Sliding window
        for (int i = 1; i <= n - k; i++) {

            int prevElement = arr.get(i - 1);
            int nextElement = arr.get(i + k - 1);

            sum = sum - prevElement + nextElement;

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(2);
        arr.add(1);
        arr.add(5);
        arr.add(1);
        arr.add(3);
        arr.add(2);

        int k = 3;

        long result = maxSubarray(k, arr);

        System.out.println("Maximum Sum = " + result);
    }
}