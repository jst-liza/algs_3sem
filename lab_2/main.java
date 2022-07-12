public class main {
    public static void main(String[] args) {

        int[] arr= new int[64];
        for (int i = 0; i < arr.length; i++)
            arr[i] = ((int)(Math.random() * 100) - 50);
        int n = arr.length;

        System.out.println("Raw array is:");
        TimSort.printArray(arr, n);
        TimSort.timSort(arr, n);
        System.out.println("Sorted array is:");
        TimSort.printArray(arr, n);
    }
}
