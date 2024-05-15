import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Change me
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-05-15
 */

/**
 * Main class
 */
public final class InsertSort {
    /** Private constructor to prevent instantiation. */
    private InsertSort() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }
    /**
     * Main method 
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(final String[] args) {
        final String inputFile = "input.txt";
        final String outputFile = "output.txt";
        try {
            // Open input and output files
            final Scanner sc = new Scanner(new File(inputFile));
            final FileWriter fW = new FileWriter(outputFile);
            final PrintWriter write = new PrintWriter(fW);
            
            // Process each line in the input file
            while (sc.hasNextLine()) {
                // Read a line of integers separated by spaces
                String StrLine = sc.nextLine();
                try {
                    // Split the line into individual integers
                    String[] StrClean = StrLine.split(" ");
                    int[] arrayNum = new int[StrClean.length];
                    // Convert strings to integers and store them in an array
                    for (int i = 0; i < StrClean.length; i++) {
                        arrayNum[i] = Integer.parseInt(StrClean[i]);
                    }

                    // Perform insertion sort on the array
                    sort(arrayNum);

                    // Write the sorted array to the output file
                    for (int num : arrayNum) {
                        write.print(num + " ");
                    }
                    // Adds newline after each array
                    write.println();
                } catch (NumberFormatException error) {
                    // Handle exception if input is not properly formatted
                    System.out.println("Input must be separated by spaces");
                }
            }
            // Close input and output files
            write.close();
            sc.close();
        } catch (Exception e) {
            // Handle exception if there is an issue with file I/O
            System.out.println("Invalid file path");
        }
    }

    /**
     * Method to perform insertion sort on an array of integers.
     * 
     * @param arrayNum Array of integers to be sorted
     */
    static void sort(int arrayNum[]) {
        // Get the length of the array
        int n = arrayNum.length;
        // Iterate through each element of the array
        for (int i = 1; i < n; ++i) {
            int key = arrayNum[i];
            int j = i - 1;
            // Move elements of arrayNum that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arrayNum[j] > key) {
                arrayNum[j + 1] = arrayNum[j];
                j = j - 1;
            }
            // Place the key at its correct position in the sorted array
            arrayNum[j + 1] = key;
        }
    }
}
