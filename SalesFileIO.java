/*
 * Class: CMSC203
 * Instructor: Farnaz Eivaz
 * Description: A class that opens and reads the text fiels and wrtiers a summary and outputs it onto the text file.
 * Due: 11/162026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Kedus Anteneh
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class SalesFileIO {

    /** Name printed at the end of the summary output. */
    public static final String PROGRAMMER_NAME = "Kedus Anteneh";

    /**
     * Reads a text file where each line holds one department space separated daily sales nd builds a ragged 2D array
     * @return ragged 2D array with one row per non-blank line
     * @throws FileNotFoundException if the file cannot be opened
     * @throws NumberFormatException if a token is not a valid number
     */
    public static double[][] readSalesData(String filename) throws FileNotFoundException {
        ArrayList<double[]> rows = new ArrayList<>();
        Scanner in = new Scanner(new File(filename));
        try {
            while (in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] tokens = line.split("\\s+");
                double[] row = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Double.parseDouble(tokens[i]);
                }
                rows.add(row);
            }
        } finally {
            in.close();
        }
        double[][] data = new double[rows.size()][];
        for (int r = 0; r < data.length; r++) {
            data[r] = rows.get(r);
        }
        return data;
    }

    /**
     * Writes a short summary of the file with the programmers name printed out at the end.
     * @param filename path of the output file
     * @param data     ragged 2D array of sales
     * @throws IOException if the file cannot be written
     */
    public static void writeSummary(String filename, double[][] data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(filename));
        try {
            out.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
            out.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
            out.println();
            for (int r = 0; r < data.length; r++) {
                out.printf("Row %d total: %.2f%n", r, SalesDataUtility.getRowTotal(data, r));
            }
            out.println();
            int cols = SalesDataUtility.getMaxColumns(data);
            for (int c = 0; c < cols; c++) {
                out.printf("Column %d total: %.2f%n", c, SalesDataUtility.getColumnTotal(data, c));
            }
            out.println();
            for (int r = 0; r < data.length; r++) {
                out.printf("Row %d highest: %.2f, lowest: %.2f%n", r,
                        SalesDataUtility.getHighestInRow(data, r),
                        SalesDataUtility.getLowestInRow(data, r));
            }
            out.println();
            out.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
            out.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));
            out.println();
            out.println("Programmer: " + PROGRAMMER_NAME);
        } finally {
            out.close();
        }
    }
}
