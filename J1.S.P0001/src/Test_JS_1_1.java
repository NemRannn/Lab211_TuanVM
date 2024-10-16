/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tuana
 */
public class Test_JS_1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Step 1: Input the positive decimal number.
        int inputSize = inputPositiveNumber();

        //Step 2: Generate random integer in number range for each array element.
        int[] randomArray = generateRandomArray(inputSize);

        //Step 3: Display the array unsorted.
        displayUnsortedArray(randomArray);

        //Step 4: Sort array using bubble sort algorithm.
        int[] sortedArray = algorithmBubbleSort(randomArray);

        //Step 5: Display the array sorted.
        displaySortedArray(sortedArray);

        //Step 6: Display sample array
        System.out.println("\n");
        System.out.println("Sample bubble sort");
        int[] testArray = {5, 1, 12, -5, 16};
        displayUnsortedArray(testArray);
        int[] sortedTestArray = algorithmBubbleSort(testArray);
        displaySortedArray(sortedTestArray);
    }

    //The function is created to check the input value
    private static Integer inputPositiveNumber() {
        Scanner sc = new Scanner(System.in);
        // Use Integer type to represent null values
        Integer number;
        //Use loop to read and check input
        while (true) {
            try {
                System.out.println("Enter number of array: ");
                //Save data user input to input
                String input = sc.nextLine();
                //check if null or empty then ask for input again
                if (input == null || input.isEmpty()) {
                    continue;
                }
                //Parse form String to integer
                number = Integer.parseInt(input);
                //Check if <=0 ask for input again
                if (number <= 0) {
                    continue;
                }
                // out the loop if succes
                break;
            } catch (NumberFormatException e) {
            }
        }
        sc.close();
        return number;
    }

    //Function to create random values ​​of array
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random rd = new Random();
        //Generate random numbers equal to the number entered by the user
        for (int i = 0; i < size; i++) {
            // Generate a random value that is not equal to 0

            int randomValue = 0;
            //use while loop to discard the zero values 
            while (randomValue == 0) {
                randomValue = rd.nextInt(size);
            }
            array[i] = randomValue;
        }
        return array;
    }

    //Display unsorted array
    private static void displayUnsortedArray(int[] array) {
        System.out.print("Unsorted array: ");
        System.out.print("[");
        //print and add "," to the elements of the array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //add ", " except the last element
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //Implement the bubbleSort
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

    //Display sorted array
    private static void displaySortedArray(int[] sortedArray) {
        System.out.print("Sorted array: ");
        System.out.print("[");
        //print and add "," to the elements of the array
        for (int i = 0; i < sortedArray.length; i++) {
            //If To the last element add "]"
            if (i < sortedArray.length - 1) {
                System.out.print(sortedArray[i] + ", ");
            } else {
                System.out.print(sortedArray[i] + "]");
            }
        }
    }

}
