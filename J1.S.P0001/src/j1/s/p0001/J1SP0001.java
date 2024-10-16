/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0001;

import java.util.Random;
import java.util.Scanner;

public class J1SP0001 {

    public static void main(String[] args) {
        // Step 1: Enter the number of array elements from the user
        int number = getInput();

        // Step 2: Create an array with random values
        int[] array = generateRandomArray(number);

        // Step 3: Display the unsorted array
        System.out.println("Unsorted array:");
        displayArray(array);

        // Step 4: Sort the array using the bubble sort algorithm and display the steps
        algorithmBubbleSortAndDisplaySteps(array);

        // Step 5: Display the sorted array
        System.out.println("Sorted array:");
        displayArray(array);
    }

    // Function to check the input value
    private static int getInput() {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.println("Enter the number of array elements: ");
                String input = sc.nextLine();
                if (input == null || input.isEmpty()) {
                    System.out.println("Please do not enter an empty value.");
                    continue;
                }
                number = Integer.parseInt(input);
                if (number <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer number.");
            }
        }
        return number;
    }

    // Function to create an array with random values
    private static int[] generateRandomArray(int number) {
        int[] array = new int[number];
        Random rd = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    // Function to display an array
    private static void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Bubble sort algorithm and display the steps
    private static void algorithmBubbleSortAndDisplaySteps(int[] array) {
        int number = array.length;
        boolean swapped;
        for (int i = 0; i < number - 1; i++) {
            swapped = false;
            for (int j = 0; j < number - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                    // Display the array after each step of sorting
                    System.out.println("Step " + (i + 1) + ":");
                    displayArray(array);
                }
            }
            if (!swapped) {
                break; // If no swaps in a step, break
            }
        }
    }
}
