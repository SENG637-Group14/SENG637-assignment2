package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;


import java.security.InvalidParameterException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DataUtilitiesTest {
    private Mockery mockingContext;
    private Values2D values2D;
    private KeyedValues keyedValues;

    @Before
    public void setUp() {
        mockingContext = new Mockery();
        values2D = mockingContext.mock(Values2D.class);
        keyedValues = mockingContext.mock(KeyedValues.class);
    }


    /**
     * Test case: Calculate column total with valid data.
     * Test strategy: The Javadoc states "Returns the sum of the values in one column of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks the basic case of summing positive values in a column.
     */
    @Test
    public void testCalculateColumnTotalForTwoValues() {

        // Example
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getRowCount();
            will(returnValue(2));
            oneOf(values2D).getValue(0, 0);
            will(returnValue(7.5));
            oneOf(values2D).getValue(1, 0);
            will(returnValue(2.5));
        }});

        // exercise
        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        // #verify
        assertEquals("Column total should be 10.0", 10.0, result, .000000001d);
    }


    /**
     * Test case: Calculate column total with positive values.
     * Test strategy: The Javadoc states "Returns the sum of the values in one column of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks the basic case of summing positive values in a column.
     */
    @Test
    public void testCalculateColumnTotalForPositiveValues() {
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getRowCount();
            will(returnValue(2));
            oneOf(values2D).getValue(0, 0);
            will(returnValue(7.5));
            oneOf(values2D).getValue(1, 0);
            will(returnValue(2.5));
        }});

        // exercise
        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        // verify
        assertEquals("Column total should be 10.0", 10.0, result, .000000001d);
    }

    /**
     * Test case: Calculate column total with negative values.
     * Test strategy: The Javadoc states "Returns the sum of the values in one column of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks the basic case of summing negative values in a column.
     */
    @Test
    public void testCalculateColumnTotalForNegativeValues() {
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getRowCount();
            will(returnValue(2));
            oneOf(values2D).getValue(0, 0);
            will(returnValue(-7.5));
            oneOf(values2D).getValue(1, 0);
            will(returnValue(-2.5));
        }});

        // exercise
        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        // verify
        assertEquals("Column total should be -10.0", -10.0, result, .000000001d);
    }

    /**
     * Test case: Calculate column total with mixed values.
     * Test strategy: The Javadoc states "Returns the sum of the values in one column of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks the case of summing both positive and negative values in a column.
     */
    @Test
    public void testCalculateColumnTotalForMixedValues() {
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getRowCount();
            will(returnValue(2));
            oneOf(values2D).getValue(0, 0);
            will(returnValue(7.5));
            oneOf(values2D).getValue(1, 0);
            will(returnValue(-2.5));
        }});

        // exercise
        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        // verify
        assertEquals("Column total should be 5.0", 5.0, result, .000000001d);
    }

    /**
     * Test case: Calculate column total with an empty data set.
     * Test strategy: The Javadoc states "Returns the sum of the values in one column of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks that an empty data set results in zero.
     */
    @Test
    public void testCalculateColumnTotalForEmptyDataSet() {
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getRowCount();
            will(returnValue(0));
        }});

        // exercise
        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        // verify
        assertEquals("Column total should be 0.0", 0.0, result, .000000001d);
    }

    /**
     * Test case: Calculate column total with a single value.
     * Test strategy: The Javadoc states "Returns the sum of the values in one column of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks that a single value in the column returns that value.
     */
    @Test
    public void testCalculateColumnTotalForSingleValue() {
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getRowCount();
            will(returnValue(1));
            oneOf(values2D).getValue(0, 0);
            will(returnValue(7.5));
        }});

        // exercise
        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        // verify
        assertEquals("Column total should be 7.5", 7.5, result, .000000001d);
    }



    /**
     * Test case: Calculate column total with invalid data, returns zero.
     * Test strategy: The Javadoc states "With invalid input, a total of zero will be returned.".
     * This tests that invalid data (empty dataset) results in zero.
     */
    @Test
    public void CalculateColumnTotalEmptyDataSet() {


        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getRowCount();
            will(returnValue(0));
        }});

        // exercise
        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        // #verify
        assertEquals("Column total should be 0.0", 0.0, result, .000000001d);
    }


    /**
     * Test case: Calculate column total with null data.
     * Test strategy: The Javadoc states "Returns the sum of the values in one column of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks that null data results in an InvalidParameterException.
     */
    @Test(expected = InvalidParameterException.class)
    public void testCalculateColumnTotalForNullData() {
        // exercise
        DataUtilities.calculateColumnTotal(null, 0);
    }

    // ---------------------------- calculateRowTotal Tests ----------------------------
    /**
     * Test case: Calculate row total with valid data.
     * Test strategy: The Javadoc states "Returns the sum of the values in one row of the supplied data table.
     * With invalid input, a total of zero will be returned." This test checks the basic case of summing a row.
     */
    @Test
    public void testCalculateRowTotalValidDataPositiveValues() {

        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getColumnCount();
            will(returnValue(3));
            oneOf(values2D).getValue(0, 0);
            will(returnValue(1.0));
            oneOf(values2D).getValue(0, 1);
            will(returnValue(2.0));
            oneOf(values2D).getValue(0, 2);
            will(returnValue(3.0));
        }});

        // exercise
        double result = DataUtilities.calculateRowTotal(values2D, 0);
        // #verify
        assertEquals("Row total should be 6.0", 6.0, result, .000000001d);
    }

    /**
     * Test case: Calculate row total with negative values.
     * Test strategy: The Javadoc states "Returns the sum of the values in one row of the supplied data table.
     * With invalid input, a total of zero will be returned." This test checks the basic case of summing a row.
     */
    @Test
    public void testCalculateRowTotalValidDataNegativeValues() {

        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getColumnCount();
            will(returnValue(3));
            oneOf(values2D).getValue(0, 0);
            will(returnValue(-1.0));
            oneOf(values2D).getValue(0, 1);
            will(returnValue(-2.0));
            oneOf(values2D).getValue(0, 2);
            will(returnValue(-3.0));
        }});

        // exercise
        double result = DataUtilities.calculateRowTotal(values2D, 0);

        // #verify
        assertEquals("Row total should be -6.0", -6.0, result, .000000001d);
    }

    /**
     * Test case: Calculate row total with null data.
     * Test strategy: The Javadoc states "Returns the sum of the values in one row of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks that null data results in an InvalidParameterException.
     */
    @Test(expected = InvalidParameterException.class)
    public void testCalculateRowTotalNullData() {
        // exercise
        DataUtilities.calculateRowTotal(null, 0);
    }

    /**
     * Test case: Calculate row total with empty data set.
     * Test strategy: The Javadoc states "Returns the sum of the values in one row of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks that an empty data set results in zero.
     */
    @Test
    public void testCalculateRowTotalEmptyDataSet() {
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getColumnCount();
            will(returnValue(0));
        }});

        // exercise
        double result = DataUtilities.calculateRowTotal(values2D, 0);

        // verify
        assertEquals("Row total should be 0.0", 0.0, result, .000000001d);
    }

    /**
     * Test case: Calculate row total with mixed values.
     * Test strategy: The Javadoc states "Returns the sum of the values in one row of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks the case of summing both positive and negative values in a row.
     */
    @Test
    public void testCalculateRowTotalMixedValues() {
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getColumnCount();
            will(returnValue(3));
            oneOf(values2D).getValue(0, 0);
            will(returnValue(1.0));
            oneOf(values2D).getValue(0, 1);
            will(returnValue(-2.0));
            oneOf(values2D).getValue(0, 2);
            will(returnValue(3.0));
        }});

        // exercise
        double result = DataUtilities.calculateRowTotal(values2D, 0);

        // verify
        assertEquals("Row total should be 2.0", 2.0, result, .000000001d);
    }

    /**
     * Test case: Calculate row total with a single value.
     * Test strategy: The Javadoc states "Returns the sum of the values in one row of the supplied data table.
     * With invalid input, a total of zero will be returned."
     * This test checks that a single value in the row returns that value.
     */
    @Test
    public void testCalculateRowTotalSingleValue() {
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getColumnCount();
            will(returnValue(1));
            oneOf(values2D).getValue(0, 0);
            will(returnValue(7.5));
        }});

        // exercise
        double result = DataUtilities.calculateRowTotal(values2D, 0);

        // verify
        assertEquals("Row total should be 7.5", 7.5, result, .000000001d);
    }
}
