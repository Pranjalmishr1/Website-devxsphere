import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    // Method to perform bucket sort
    public static void bucketSort(float[] arr) {
        // Create an array of buckets
        int n = arr.length;
        if (n <= 0) return;

        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];

        // Initialize buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute input array values into buckets
        for (float num : arr) {
            int bucketIndex = (int) (num * n); // Use the number multiplied by n to find the bucket index
            if (bucketIndex >= n) bucketIndex = n - 1; // Ensure it doesn't go out of bounds
            buckets[bucketIndex].add(num);
        }

        // Sort individual buckets and concatenate the results
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket); // Sort the individual bucket
            for (float num : bucket) {
                arr[index++] = num; // Place the sorted elements back into the original array
            }
        }
    }

    // Helper method to print the array
    public static void printArray(float[] arr) {
        for (float value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example array
        float[] arr = {0.42f, 0.32f, 0.23f, 0.51f, 0.10f, 0.34f, 0.55f};

        System.out.println("Original array:");
        printArray(arr);

        // Call the bucket sort method
        bucketSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
