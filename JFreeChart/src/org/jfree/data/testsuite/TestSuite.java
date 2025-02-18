package org.jfree.data.testsuite;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.*;

public class TestSuite {
    
    private Range exampleRange;
    private Mockery mockingContext;
    private Values2D values2D;
    private KeyedValues keyedValues;

    @Before
    public void setUp() {
        // Set up a sample range and mock objects before each test
        exampleRange = new Range(-1, 1);
        mockingContext = new Mockery();
        values2D = mockingContext.mock(Values2D.class);
        keyedValues = mockingContext.mock(KeyedValues.class);
    }
    
    // -------------- RangeTests --------------
    
 // -------------- Central Value Tests --------------

    /**
     * Test case: To get central value of the range.
     * Test strategy: The Javadoc states "Returns the central (or median) value for the range."
     * This test verifies the central value calculation for a simple range.
     */
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
                0, exampleRange.getCentralValue(), .000000001d);
    }

    /**
     * Test case: Central value for a positive range.
     * Test strategy: The method should return the midpoint of the range.
     * Expected output: (2+6)/2 = 4.0
     */
    @Test
    public void testCentralValuePositiveRange() {
        Range range = new Range(2, 6);
        assertEquals(4.0, range.getCentralValue(), 0.0001);
    }

    /**
     * Test case: Central value for a negative range.
     * Test strategy: The method should return the midpoint of the range.
     * Expected output: (-6 + -2)/2 = -4.0
     */
    @Test
    public void testCentralValueNegativeRange() {
        Range range = new Range(-6, -2);
        assertEquals(-4.0, range.getCentralValue(), 0.0001);
    }

    /**
     * Test case: Central value when the lower and upper bounds are the same.
     * Test strategy: The method should return the same value.
     * Expected output: 5.0
     */
    @Test
    public void testCentralValueSameBounds() {
        Range range = new Range(5, 5);
        assertEquals(5.0, range.getCentralValue(), 0.0001);
    }

    /**
     * Test case: Central value for an extreme range.
     * Test strategy: This tests large value handling.
     * Expected output: ( -MAX_VALUE + MAX_VALUE ) / 2 = 0.0
     */
    @Test
    public void testCentralValueExtremeRange() {
        Range range = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals(0.0, range.getCentralValue(), 0.0001);
    }

    // -------------- Lower Bound Tests --------------

    /**
     * Test case: Get lower bound of the range.
     * Test strategy: The Javadoc states "Returns the lower bound for the range."
     * This test verifies the lower bound for a known range.
     */
    @Test
    public void lowerBoundShouldBeNegativeOne() {
        assertEquals("Lower bound should be -1", -1, exampleRange.getLowerBound(), .000000001d);
    }

    /**
     * Test case: Lower bound for a positive range.
     * Test strategy: The method should return the minimum value in the range.
     * Expected output: 2.0
     */
    @Test
    public void testLowerBoundPositiveRange() {
        Range range = new Range(2, 6);
        assertEquals(2.0, range.getLowerBound(), 0.0001);
    }

    /**
     * Test case: Lower bound for a negative range.
     * Test strategy: The method should return the minimum value in the range.
     * Expected output: -6.0
     */
    @Test
    public void testLowerBoundNegativeRange() {
        Range range = new Range(-6, -2);
        assertEquals(-6.0, range.getLowerBound(), 0.0001);
    }

    /**
     * Test case: Lower bound for an extreme range.
     * Test strategy: This tests handling of large double values.
     * Expected output: -Double.MAX_VALUE
     */
    @Test
    public void testLowerBoundExtremeRange() {
        Range range = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals(-Double.MAX_VALUE, range.getLowerBound(), 0.0001);
    }

    // -------------- Upper Bound Tests --------------

    /**
     * Test case: Get upper bound of the range.
     * Test strategy: The Javadoc states "Returns the upper bound for the range."
     * This test verifies the upper bound for a known range.
     */
    @Test
    public void upperBoundShouldBeOne() {
        assertEquals("Upper bound should be 1", 1, exampleRange.getUpperBound(), .000000001d);
    }

    /**
     * Test case: Upper bound for a positive range.
     * Test strategy: The method should return the maximum value in the range.
     * Expected output: 6.0
     */
    @Test
    public void testUpperBoundPositiveRange() {
        Range range = new Range(2, 6);
        assertEquals(6.0, range.getUpperBound(), 0.0001);
    }

    /**
     * Test case: Upper bound for a negative range.
     * Test strategy: The method should return the maximum value in the range.
     * Expected output: -2.0
     */
    @Test
    public void testUpperBoundNegativeRange() {
        Range range = new Range(-6, -2);
        assertEquals(-2.0, range.getUpperBound(), 0.0001);
    }

    /**
     * Test case: Upper bound for an extreme range.
     * Test strategy: This tests handling of large double values.
     * Expected output: Double.MAX_VALUE
     */
    @Test
    public void testUpperBoundExtremeRange() {
        Range range = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, range.getUpperBound(), 0.0001);
    }

    /**
     * Test case: Upper bound when the range includes positive infinity.
     * Test strategy: The method should return Double.POSITIVE_INFINITY.
     * Expected output: Double.POSITIVE_INFINITY
     */
    @Test
    public void testUpperBoundPositiveInfinity() {
        Range range = new Range(-1000, Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, range.getUpperBound(), 0.0001);
    }

    // -------------- Contains Method Tests --------------

    /**
     * Test case: Check if the range contains zero.
     * Test strategy: The Javadoc states "Returns true if the specified value is within the range."
     * Since zero is within the default range (-1,1), the result should be true.
     */
    @Test
    public void testRangeContainsZero() {
        assertTrue(exampleRange.contains(0));
    }

    /**
     * Test case: Check if the range contains a value within its bounds.
     * Test strategy: The method should return true if the value is within the given range.
     * Expected output: true (3 is within -5 to 5).
     */
    @Test
    public void testRangeContainsValueWithin() {
        assertTrue(new Range(-5, 5).contains(3));
    }

    /**
     * Test case: Check if the range does not contain a value outside its bounds.
     * Test strategy: The method should return false if the value is outside the range.
     * Expected output: false (-1 is not within 1 to 10).
     */
    @Test
    public void testRangeDoesNotContainValue() {
        assertFalse(new Range(1, 10).contains(-1));
    }

    /**
     * Test case: Check boundary value at the lower bound.
     * Test strategy: The method should return true if the value is equal to the lower bound.
     * Expected output: true (-1 is the lower bound of exampleRange).
     */
    @Test
    public void testRangeContainsLowerBound() {
        assertTrue(exampleRange.contains(-1));
    }

    /**
     * Test case: Check boundary value at the upper bound.
     * Test strategy: The method should return true if the value is equal to the upper bound.
     * Expected output: true (1 is the upper bound of exampleRange).
     */
    @Test
    public void testRangeContainsUpperBound() {
        assertTrue(exampleRange.contains(1));
    }

    /**
     * Test case: Check if the range contains an extreme value.
     * Test strategy: If the value is much larger or smaller than the range, return false.
     * Expected output: false (100 is not within -1 to 1).
     */
    @Test
    public void testRangeDoesNotContainExtremeValue() {
        assertFalse(exampleRange.contains(100));
    }

    // -------------- Combine Method Tests --------------

    /**
     * Test case: Combining two null ranges should return null.
     * Test strategy: The Javadoc states "If both ranges are null, the return value is null."
     * Expected output: null.
     */
    @Test
    public void testCombineNullRanges() {
        assertNull(Range.combine(null, null));
    }

    /**
     * Test case: Combining a null range with a valid range should return the valid range.
     * Test strategy: The Javadoc states "If one range is null, return the other range."
     * Expected output: The non-null range.
     */
    @Test
    public void testCombineOneNullRange() {
        Range range = new Range(1, 10);
        assertEquals(range, Range.combine(range, null));
    }

    /**
     * Test case: Combine two non-overlapping positive ranges.
     * Test strategy: The combined range should extend from the lower bound of the first to the upper bound of the second.
     * Expected output: Range(1, 20).
     */
    @Test
    public void testCombineNonOverlappingRanges() {
        Range range1 = new Range(1, 10);
        Range range2 = new Range(15, 20);
        Range combined = Range.combine(range1, range2);
        assertEquals(new Range(1, 20), combined);
    }

    /**
     * Test case: Combine two overlapping ranges.
     * Test strategy: The combined range should merge overlapping regions.
     * Expected output: Range(-5, 10).
     */
    @Test
    public void testCombineOverlappingRanges() {
        Range range1 = new Range(-5, 5);
        Range range2 = new Range(3, 10);
        Range combined = Range.combine(range1, range2);
        assertEquals(new Range(-5, 10), combined);
    }

    /**
     * Test case: Combine two adjacent ranges.
     * Test strategy: The combined range should include both ranges without gaps.
     * Expected output: Range(5, 15).
     */
    @Test
    public void testCombineAdjacentRanges() {
        Range range1 = new Range(5, 10);
        Range range2 = new Range(10, 15);
        Range combined = Range.combine(range1, range2);
        assertEquals(new Range(5, 15), combined);
    }

    /**
     * Test case: Combine two identical ranges.
     * Test strategy: The combined range should remain unchanged.
     * Expected output: Range(3, 7).
     */
    @Test
    public void testCombineIdenticalRanges() {
        Range range1 = new Range(3, 7);
        Range range2 = new Range(3, 7);
        Range combined = Range.combine(range1, range2);
        assertEquals(new Range(3, 7), combined);
    }

    /**
     * Test case: Combine two extreme ranges (infinity cases).
     * Test strategy: The combined range should handle extreme values.
     * Expected output: Range(-∞, ∞).
     */
    @Test
    public void testCombineExtremeRanges() {
        Range range1 = new Range(Double.NEGATIVE_INFINITY, -100);
        Range range2 = new Range(100, Double.POSITIVE_INFINITY);
        Range combined = Range.combine(range1, range2);
        assertEquals(new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY), combined);
    }
    
// ---------------DataUtilities Test-------------------
 // ---------------------------- calculateColumnTotal Tests ----------------------------
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


    // ---------------------------- createNumberArray2D Tests ----------------------------

    /**
     * Test case: Create a 2D Number array with an empty double array.
     * Test strategy: The Javadoc states "Constructs an array of arrays of Number objects from a corresponding structure containing double primitives."
     * This tests the creation of the 2D array when the input array is empty.
     */
    @Test
    public void testCreateNumberArray2DEmptyArray() {

        // #exercise
        double[][] data = {};
        Number[][] result = DataUtilities.createNumberArray2D(data);

        // #verify
        assertEquals("Number array length should be 0", 0, result.length);
    }
    /**
     * Test case: Create a 2D Number array with valid data.
     * Test strategy: The Javadoc states "Constructs an array of arrays of Number objects from a corresponding structure containing double primitives."
     * This test checks the basic case of converting a 2D array of doubles to a 2D array of Numbers.
     */
    @Test
    public void testCreateNumberArray2DValidData() {
        double[][] data = {
                {1.1, 2.2},
                {3.3, 4.4}
        };

        // exercise
        Number[][] result = DataUtilities.createNumberArray2D(data);

        // verify
        Number[][] expected = {
                {1.1, 2.2},
                {3.3, 4.4}
        };
        assertArrayEquals("2D Number array should match the expected values", expected, result);
    }

    /**
     * Test case: Create a 2D Number array with null data.
     * Test strategy: The Javadoc states "Constructs an array of arrays of Number objects from a corresponding structure containing double primitives."
     * This test checks that null data results in an InvalidParameterException.
     */
    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArray2DNullData() {
        // exercise
        DataUtilities.createNumberArray2D(null);
    }


    /**
     * Test case: Create a 2D Number array with a single row.
     * Test strategy: The Javadoc states "Constructs an array of arrays of Number objects from a corresponding structure containing double primitives."
     * This test checks the creation of the 2D array when the input array has a single row.
     */
    @Test
    public void testCreateNumberArray2DSingleRow() {
        double[][] data = {
                {1.1, 2.2, 3.3}
        };

        // exercise
        Number[][] result = DataUtilities.createNumberArray2D(data);

        // verify
        Number[][] expected = {
                {1.1, 2.2, 3.3}
        };
        assertArrayEquals("2D Number array should match the expected values", expected, result);
    }

    /**
     * Test case: Create a 2D Number array with a single column.
     * Test strategy: The Javadoc states "Constructs an array of arrays of Number objects from a corresponding structure containing double primitives."
     * This test checks the creation of the 2D array when the input array has a single column.
     */
    @Test
    public void testCreateNumberArray2DSingleColumn() {
        double[][] data = {
                {1.1},
                {2.2},
                {3.3}
        };

        // exercise
        Number[][] result = DataUtilities.createNumberArray2D(data);

        // verify
        Number[][] expected = {
                {1.1},
                {2.2},
                {3.3}
        };
        assertArrayEquals("2D Number array should match the expected values", expected, result);
    }

    /**
     * Test case: Create a 2D Number array with null row.
     * Test strategy: The Javadoc states "Constructs an array of arrays of Number objects from a corresponding structure containing double primitives."
     * This test checks that a null row in the input array results in an InvalidParameterException.
     */
    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArray2DNullRow() {
        double[][] data = {
                {1.1, 2.2},
                null
        };

        // exercise
        DataUtilities.createNumberArray2D(data);
    }

    // ---------------------------- getCumulativePercentages Tests ----------------------------

    /**
     * Test case: Get cumulative percentages with valid data.
     * Test strategy: The Javadoc states "Returns a KeyedValues instance that contains the cumulative percentage values for the data in another KeyedValues instance."
     *  This tests the creation of cumulative percentages array with valid values.
     */
    @Test
    public void testGetCumulativePercentagesValidData() {

        mockingContext.checking(new Expectations() {{
            allowing(keyedValues).getItemCount();
            will(returnValue(3));
            allowing(keyedValues).getValue(0);
            will(returnValue(5));
            allowing(keyedValues).getValue(1);
            will(returnValue(9));
            allowing(keyedValues).getValue(2);
            will(returnValue(2));
            allowing(keyedValues).getKey(0);
            will(returnValue(0));
            allowing(keyedValues).getKey(1);
            will(returnValue(1));
            allowing(keyedValues).getKey(2);
            will(returnValue(2));
        }});

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);

        // #verify
        assertEquals("First cumulative percentage should be 0.3125", 0.3125, result.getValue(0).doubleValue(), .000000001d);
        assertEquals("Second cumulative percentage should be 0.875", 0.875, result.getValue(1).doubleValue(), .000000001d);
        assertEquals("Third cumulative percentage should be 1.0", 1.0, result.getValue(2).doubleValue(), .000000001d);
    }


    /**
     * Test case: Get cumulative percentages with null data.
     * Test strategy: The Javadoc states "Returns a KeyedValues instance that contains the cumulative percentage values for the data in another KeyedValues instance."
     * This test checks that null data results in an InvalidParameterException.
     */
    @Test(expected = InvalidParameterException.class)
    public void testGetCumulativePercentagesNullData() {
        // exercise
        DataUtilities.getCumulativePercentages(null);
    }

    /**
     * Test case: Get cumulative percentages with empty data.
     * Test strategy: The Javadoc states "Returns a KeyedValues instance that contains the cumulative percentage values for the data in another KeyedValues instance."
     * This test checks that an empty data set results in an empty cumulative percentages set.
     */
    @Test
    public void testGetCumulativePercentagesEmptyData() {
        mockingContext.checking(new Expectations() {{
            allowing(keyedValues).getItemCount();
            will(returnValue(0));
        }});

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);

        // verify
        assertEquals("Cumulative percentages should be empty", 0, result.getItemCount());
    }
    /**
     * Test case: Get cumulative percentages with single value.
     * Test strategy: The Javadoc states "Returns a KeyedValues instance that contains the cumulative percentage values for the data in another KeyedValues instance."
     * This test checks that a single value results in a cumulative percentage of 1.0.
     */
    @Test
    public void testGetCumulativePercentagesSingleValue() {
        mockingContext.checking(new Expectations() {{
            allowing(keyedValues).getItemCount();
            will(returnValue(1));
            allowing(keyedValues).getValue(0);
            will(returnValue(5));
            allowing(keyedValues).getKey(0);
            will(returnValue(0));
        }});

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);

        // verify
        assertEquals("Cumulative percentage should be 1.0", 1.0, result.getValue(0).doubleValue(), .000000001d);
    }
    // ---------------------------- createNumberArray Tests ----------------------------


    /**
     * Test case: Create a Number array with valid data.
     * Test strategy: The Javadoc states "Constructs an array of Number objects from an array of double primitives."
     * This test checks the basic case of converting an array of doubles to an array of Numbers.
     */
    @Test
    public void testCreateNumberArrayValidData() {
        double[] data = {1.1, 2.2, 3.3};

        // exercise
        Number[] result = DataUtilities.createNumberArray(data);

        // verify
        Number[] expected = {1.1, 2.2, 3.3};
        assertArrayEquals("Number array should match the expected values", expected, result);
    }

    /**
     * Test case: Create a Number array with null data.
     * Test strategy: The Javadoc states "Constructs an array of Number objects from an array of double primitives."
     * This test checks that null data results in an InvalidParameterException.
     */
    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArrayNullData() {
        // exercise
        DataUtilities.createNumberArray(null);
    }

    /**
     * Test case: Create a Number array with an empty array.
     * Test strategy: The Javadoc states "Constructs an array of Number objects from an array of double primitives."
     * This test checks the creation of the array when the input array is empty.
     */
    @Test
    public void testCreateNumberArrayEmptyArray() {
        double[] data = {};

        // exercise
        Number[] result = DataUtilities.createNumberArray(data);

        // verify
        Number[] expected = {};
        assertArrayEquals("Number array should be empty", expected, result);
    }

    /**
     * Test case: Create a Number array with a single value.
     * Test strategy: The Javadoc states "Constructs an array of Number objects from an array of double primitives."
     * This test checks that a single value in the input array returns that value.
     */
    @Test
    public void testCreateNumberArraySingleValue() {
        double[] data = {7.5};

        // exercise
        Number[] result = DataUtilities.createNumberArray(data);

        // verify
        Number[] expected = {7.5};
        assertArrayEquals("Number array should match the expected value", expected, result);
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
}
