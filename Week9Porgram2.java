package week9;

//Claire Francis, Week9Program2, October 30, 2025

// Write a program that computes and displays the following statistics about the file.
// 1) Quantity of numbers in the file.
// 2) The average (mean) of the data.
// 3) The largest number in the data.
// 4) The smallest number in the data.
// 5) The range of the data (highest number - lowest number)







import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.File;
public class Week9Porgram2 {

	public static void main(String[] args) {
		String fileName = "C:\\Users\\clair\\Documents\\FileforWeek9CodeExample.txt";
		
        int numbers = 0;
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            // Read all numbers (handles spaces, tabs, and new lines)
            while (fileScanner.hasNext()) {
                if (fileScanner.hasNextDouble()) {
                    double num = fileScanner.nextDouble();
                    sum += num;
                    numbers++;

                    if (num < min) min = num;
                    if (num > max) max = num;
                } else {
                    // Skip any non-numeric tokens
                    fileScanner.next();
                }
            }
            fileScanner.close();

            if (numbers > 0) {
                double average = sum / numbers;
                double range = max - min;

                System.out.println("File: " + fileName);
                System.out.println("1) Quantity of numbers: " + numbers);
                System.out.println("2) Average (mean): " + average);
                System.out.println("3) Largest number: " + max);
                System.out.println("4) Smallest number: " + min);
                System.out.println("5) Range: " + range);
            } else {
                System.out.println("No numbers found in the file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + fileName);
        }
    }
}
