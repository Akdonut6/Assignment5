/*
 * Class: CMSC203
 * Instructor: Farnaz Eivaz
 * Description: Static utility methods for a ragged 2D array of store sales data.
 * Due: 11/16/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Kedus Anteneh
 */

/**
 * Static utility class for processing ragged 2D arrays of sales data.
 * Each row is a department; each column is a day. Rows may differ in length.
 */
public class SalesDataUtility {

    /** Utility class: not meant to be instantiated. */
    private SalesDataUtility() {
    }

    /**
     * Adds up every value in the array.
     * @param data ragged 2D array of sales
     * @return the sum of all values (0 if the array is empty)
     */
    public static double getTotal(double[][] data) {
        double total = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                total += data[r][c];
            }
        }
        return total;
    }

    /**
     * Computes the average of all values in the array (total / number of values).
     * @param data ragged 2D array of sales
     * @return the average, or 0 if there are no values
     */
    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                total += data[r][c];
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    /**
     * Adds up all the values in one row.
     * @param data ragged 2D array of sales
     * @param row  the row index
     * @return the row total, or 0 if the row index is invalid
     */
    public static double getRowTotal(double[][] data, int row) {
        if (row < 0 || row >= data.length) {
            return 0;
        }
        double total = 0;
        for (int c = 0; c < data[row].length; c++) {
            total += data[row][c];
        }
        return total;
    }

    /**
     * Adds up all the values in one column. Rows that are too short to
     * have the requested column are skipped.
     * @param data ragged 2D array of sales
     * @param col  the column index
     * @return the column total (0 if no row has that column)
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        if (col < 0) {
            return 0;
        }
        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                total += data[r][col];
            }
        }
        return total;
    }

    /**
     * Finds the highest value in one row.
     * @param data ragged 2D array of sales
     * @param row  the row index
     * @return the highest value in the row, or 0 if the row is invalid or empty
     */
    public static double getHighestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0;
        }
        double highest = data[row][0];
        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] > highest) {
                highest = data[row][c];
            }
        }
        return highest;
    }

    /**
     * Finds the lowest value in one row.
     * @param data ragged 2D array of sales
     * @param row  the row index
     * @return the lowest value in the row, or 0 if the row is invalid or empty
     */
    public static double getLowestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0;
        }
        double lowest = data[row][0];
        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] < lowest) {
                lowest = data[row][c];
            }
        }
        return lowest;
    }

    /**
     * Finds the highest value anywhere in the array.
     * @param data ragged 2D array of sales
     * @return the highest value, or 0 if the array holds no values
     */
    public static double getHighestInArray(double[][] data) {
        boolean found = false;
        double highest = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (!found || data[r][c] > highest) {
                    highest = data[r][c];
                    found = true;
                }
            }
        }
        return highest;
    }

    /**
     * Finds the lowest value anywhere in the array.
     * @param data ragged 2D array of sales
     * @return the lowest value, or 0 if the array holds no values
     */
    public static double getLowestInArray(double[][] data) {
        boolean found = false;
        double lowest = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (!found || data[r][c] < lowest) {
                    lowest = data[r][c];
                    found = true;
                }
            }
        }
        return lowest;
    }

    /**
     * Finds the length of the longest row (the number of columns to report on).
     * @param data ragged 2D array of sales
     * @return the maximum row length, or 0 for an empty array
     */
    public static int getMaxColumns(double[][] data) {
        int max = 0;
        for (int r = 0; r < data.length; r++) {
            if (data[r].length > max) {
                max = data[r].length;
            }
        }
        return max;
    }
}
