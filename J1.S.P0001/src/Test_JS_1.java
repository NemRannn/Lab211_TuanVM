import java.util.Random;
import java.util.Scanner;

public class Test_JS_1 {
    public static void main(String[] args) {
        // Step 1: Input the positive decimal number.
        int inputSize = inputPositiveNumber();

        // Step 2: Generate random integer in the number range for each array element.
        int[] randomArray = generateRandomArray(inputSize);

        // Step 3: Display the array unsorted.
        displayUnsortedArray(randomArray);

        // Step 4: Sort the array using the bubble sort algorithm.
        int[] sortedArray = algorithmBubbleSort(randomArray);

        // Step 5: Display the array sorted.
        displaySortedArray(sortedArray);

        // Wait for Enter key press before displaying the steps for the fixed array
        System.out.println("Press Enter to display steps for the fixed array...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // Step 6: Display the sample array
        int[] testArray = {5, 1, 12, -5, 16};

        // Display the unsorted testArray
        System.out.print("Test bubblesort algorithm\n [");
        displayUnsortedArray(testArray);
        System.out.println("]    unsorted");

        // Call algorithmBubbleSort to sort the testArray
        int[] sortedTestArray = algorithmBubbleSort(testArray);

        // Display the sorted testArray
        System.out.print(" [");
        displaySortedArray(sortedTestArray);
        System.out.println("]    Sorted");
    }

    // The rest of your methods...

    private static Integer inputPositiveNumber() {
        Scanner sc = new Scanner(System.in);
        // Use Integer type to represent null values
        Integer number;
        // Use loop to read and check input
        while (true) {
            try {
                System.out.println("Enter number of array: ");
                // Save data user input to input
                String input = sc.nextLine();
                // Check if null or empty then ask for input again
                if (input == null || input.isEmpty()) {
                    continue;
                }
                // Parse from String to integer
                number = Integer.parseInt(input);
                // Check if <=0 ask for input again
                if (number <= 0) {
                    continue;
                }
                // Out the loop if success
                break;
            } catch (NumberFormatException e) {
            }
        }
        sc.close();
        return number;
    }

    private static int[] generateRandomArray(int size) {
        Random rd = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int randomValue = rd.nextInt(size);
            while (randomValue == 0) {
                randomValue = rd.nextInt(size);
            }
            array[i] = randomValue;
        }
        return array;
    }

    private static void displayUnsortedArray(int[] array) {
        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int[] algorithmBubbleSort(int[] array) {
        int number = array.length;
        boolean swap;

        System.out.print(" [");
        for (int i = 0; i < number; i++) {
            System.out.print(array[i]);
            if (i < number - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]    unsorted");

        for (int i = 0; i < number - 1; i++) {
            swap = false;
            for (int j = 0; j < number - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;

                    System.out.print(" [");
                    for (int k = 0; k < number; k++) {
                        System.out.print(array[k]);
                        if (k < number - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.print("]    ");
                    System.out.print(array[j] + " > " + array[j + 1] + ", swap\n");
                } else {
                    System.out.print(" [");
                    for (int k = 0; k < number; k++) {
                        System.out.print(array[k]);
                        if (k < number - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.print("]    ");
                    System.out.print(array[j] + " < " + array[j + 1] + ", ok\n");
                }
            }
            if (!swap) {
                break;
            }
        }
        return array;
    }

    private static void displaySortedArray(int[] sortedArray) {
        System.out.print("Sorted array: ");
        System.out.print("[");
        for (int i = 0; i < sortedArray.length; i++) {
            if (i < sortedArray.length - 1) {
                System.out.print(sortedArray[i] + ", ");
            } else {
                System.out.print(sortedArray[i] + "]");
            }
        }
    }
}
