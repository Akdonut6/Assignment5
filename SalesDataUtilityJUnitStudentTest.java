/*
 * Class: CMSC203
 * Instructor: Farnaz Eivaz
 * Description: basically a class to handle all the math getting done withint the program.
 * Due: 11/162026
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Kedus Anteneh
 */

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit tests covering every SalesDataUtility method with ragged arrays.
 */
public class SalesDataUtilityJUnitStudentTest {

    private double[][] sample = {
        {100.0, 200.0, 300.0},
        {50.0, 75.0},
        {400.0}
    };

    private double[][] fileData = {
        {100.50, 200.75, 150.00},
        {80.00, 90.00},
        {220.10, 130.50, 300.00, 50.25}
    };

    @Test
    public void testGetTotal() {
        assertEquals(1125.0, SalesDataUtility.getTotal(sample), 0.001);
        assertEquals(1322.10, SalesDataUtility.getTotal(fileData), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(187.5, SalesDataUtility.getAverage(sample), 0.001);
        assertEquals(146.90, SalesDataUtility.getAverage(fileData), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(600.0, SalesDataUtility.getRowTotal(sample, 0), 0.001);
        assertEquals(125.0, SalesDataUtility.getRowTotal(sample, 1), 0.001);
        assertEquals(400.0, SalesDataUtility.getRowTotal(sample, 2), 0.001);
        assertEquals(0.0, SalesDataUtility.getRowTotal(sample, 5), 0.001);
    }

    @Test
    public void testGetColumnTotalRagged() {
        assertEquals(550.0, SalesDataUtility.getColumnTotal(sample, 0), 0.001);
        assertEquals(275.0, SalesDataUtility.getColumnTotal(sample, 1), 0.001);
        assertEquals(300.0, SalesDataUtility.getColumnTotal(sample, 2), 0.001);
        assertEquals(0.0, SalesDataUtility.getColumnTotal(sample, 3), 0.001);
    }

    @Test
    public void testHighestLowestInRow() {
        assertEquals(300.0, SalesDataUtility.getHighestInRow(sample, 0), 0.001);
        assertEquals(100.0, SalesDataUtility.getLowestInRow(sample, 0), 0.001);
        assertEquals(75.0, SalesDataUtility.getHighestInRow(sample, 1), 0.001);
        assertEquals(50.0, SalesDataUtility.getLowestInRow(sample, 1), 0.001);
        assertEquals(400.0, SalesDataUtility.getHighestInRow(sample, 2), 0.001);
        assertEquals(400.0, SalesDataUtility.getLowestInRow(sample, 2), 0.001);
    }

    @Test
    public void testHighestLowestArray() {
        assertEquals(400.0, SalesDataUtility.getHighestInArray(sample), 0.001);
        assertEquals(50.0, SalesDataUtility.getLowestInArray(sample), 0.001);
    }

    @Test
    public void testEmptyArray() {
        double[][] empty = new double[0][];
        assertEquals(0.0, SalesDataUtility.getTotal(empty), 0.001);
        assertEquals(0.0, SalesDataUtility.getAverage(empty), 0.001);
        assertEquals(0, SalesDataUtility.getMaxColumns(empty));
    }
}