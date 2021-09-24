import java.util.Arrays;

public class MyMain {
    // Write a method that prints out all the even numbers in an array backwards
    // Ex: printEvensBackwards([1, 2, 3, 4, 5, 6]) =>
    //     6
    //     4
    //     2
    public static void printEvensBackwards(int[] arr) {
        // REPLACE THIS WITH YOUR CODE
        for (int i= arr.length - 1;i >= 0; i-= 1){
            if (arr[i] % 2 == 0){
                System.out.println(arr[i]);
            }
        }
    }

    // Next, write a method that checks if an array is sorted in
    // strictly increasing order (i.e. each element must be greater
    // than the previous element)
    // Ex: isIncreasing([1, 2, 3, 4, 5, 6]) => true
    //     isIncreasing([1, 1, 3, 6, 7]) => false (because 1 is not > 1)
    //     isIncreasing([1, 2, 3, 2, 4, 5, 8]) => false
    public static boolean isIncreasing(int[] arr) {
        // REPLACE THIS WITH YOUR CODE
        for(int i=1;i<arr.length;i++){
            if (arr[i] <= arr[i - 1]){
                    return false;
                }

        }
        return true;
    }

    // (Maybe Optional):
    // Write a method that checks if an array is "balanced". An array
    // is balanced if the first and last values differ by at most 2, and
    // if the second and second to last values differ by at most 2, and so on
    // Ex: isBalanced([1, 2, 3, 2, 1]) => true
    //     isBalanced([1, 2, 3, 4, 1, -1]) => true
    //     isBalanced([1, 2, 3, 7, 2, 1]) => false (because 7 - 3 > 2)
    public static boolean isBalanced(int[] arr) {
        // REPLACE THIS WITH YOUR CODE
        for (int i=0;i<arr.length;i++){
            if(Math.abs(arr[i] - arr[arr.length - i - 1]) > 2){
                return false;
            }
        }
        return true;
    }

    // Write a method that takes an array and checks if it contains
    // any duplicate values
    // Ex: containsDuplicates([1, 2, 3, 2, 1]) => true
    //     containsDuplicates([7, 2, 3, 4, 1, 5]) => false
    public static boolean containsDuplicates(int[] arr) {
        // REPLACE THIS WITH YOUR CODE
        for (int i=0;i<arr.length;i++){
            if (i != 0){
                for (int j=0;j<i;j++){
                    if (arr[j] == arr[i]){
                        return true;
                    }
                }
            }

        }
        return false;
    }

    // Sorting:
    // Implement the bubble sort algorithm that we discussed in class
    // to sort our code
    // This algorithm returns the sorted array
    public static int[] FindLargestNum(int[] arr){
        int max = 0;
        int index = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        return new int[]{max, index};
    }
    public static int[] PruneList(int[] arr, int index){
        int[] newArr = new int[arr.length - 1];
        int count = 0;
        for(int i =0; i < arr.length; i ++){
            if(i == index){
                continue;
            }
            else{
                newArr[count] = arr[i];
                count ++;
            }
        }

        return newArr;
    }
    public static int[] reverseList(int[] arr){
        int[] newArr = new int[arr.length];
        int count = 0;
        for(int i = arr.length - 1; i >= 0; i --){
            newArr[count] = arr[i];
            count ++;
        }
        return newArr;
    }
    public static int[] bubbleSort(int[] arr) {
        int[] finalArr = new int[arr.length];
        int[] Arr = arr.clone();
        int[] largestNum;
        for (int i = 0; i < arr.length; i ++){
            largestNum = FindLargestNum(Arr);
            Arr = PruneList(Arr, largestNum[1]);
            finalArr[i] = largestNum[0];

        }
        return reverseList(finalArr);
    }


    public static void main(String[] args) {
        System.out.println("printEvensBackwards Tests:");
        printEvensBackwards(new int[] {1, 2, 3, 4, 5, 6});
        // 6
        // 4
        // 2

        System.out.println();
        System.out.println("isIncreasing Tests:");
        System.out.println(isIncreasing(new int[] {1, 2, 3, 4, 5, 6})); // true
        System.out.println(isIncreasing(new int[] {1, 1, 3, 6, 7})); // false (because 1 is not > 1)
        System.out.println(isIncreasing(new int[] {1, 2, 3, 2, 4, 5, 8})); // false

        System.out.println();
        System.out.println("isBalanced Tests:");
        System.out.println(isBalanced(new int[] {1, 2, 3, 2, 1})); // true
        System.out.println(isBalanced(new int[] {1, 2, 3, 4, 1, -1})); //true
        System.out.println(isBalanced(new int[] {1, 2, 3, 7, 2, 1})); // false (because 7 - 3 > 2)

        System.out.println();
        System.out.println("containsDuplicates Tests:");
        System.out.println(containsDuplicates(new int[] {1, 2, 3, 2, 1})); // true
        System.out.println(containsDuplicates(new int[] {7, 2, 3, 4, 1, 5})); // false

        System.out.println();
        System.out.println("Bubble Sort Tests");
        System.out.println(Arrays.toString(bubbleSort(new int[]{6, 1, 3, 8, 2, 9}))); // [1, 2, 3, 6, 8, 9]
        System.out.println(Arrays.toString(bubbleSort(new int[]{12, 5, 23, 74, 12, 86, 2}))); // [2, 5, 12, 23, 74, 86]
    }
}