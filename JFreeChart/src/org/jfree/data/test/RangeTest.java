package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        exampleRange = new Range(-1, 1);
    }

    /**
     * Test case: Get central value of the range.
     * Test strategy: The Javadoc states "Returns the central (or median) value for the range."
     * Check the central value for a known range.
     */
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
                0, exampleRange.getCentralValue(), .000000001d);
    }
    /**
     * Test the central value for a positive range (2,6).
     * Expected output: (2+6)/2 = 4.0
     */
    @Test
    public void testCentralValuePositiveRange() {
        Range range = new Range(2, 6);
        assertEquals(4.0, range.getCentralValue(), 0.0001);
    }

    /**
     * Test the central value for a negative range (-6,-2).
     * Expected output: (-6 + -2)/2 = -4.0
     */
    @Test
    public void testCentralValueNegativeRange() {
        Range range = new Range(-6, -2);
        assertEquals(-4.0, range.getCentralValue(), 0.0001);
    }

    /**
     * Test the central value for a range that crosses zero (-1,1).
     * Expected output: (-1+1)/2 = 0.0
     */
    @Test
    public void testCentralValueCrossingZero() {
        assertEquals(0.0, exampleRange.getCentralValue(), 0.0001);
    }

    /**
     * Test the central value when the lower and upper bounds are the same (5,5).
     * Expected output: 5.0
     */
    @Test
    public void testCentralValueSameBounds() {
        Range range = new Range(5, 5);
        assertEquals(5.0, range.getCentralValue(), 0.0001);
    }

    /**
     * Test the central value for a large range (-1000, 1000).
     * Expected output: ( -1000 + 1000 ) / 2 = 0.0
     */
    @Test
    public void testCentralValueLargeRange() {
        Range range = new Range(-1000, 1000);
        assertEquals(0.0, range.getCentralValue(), 0.0001);
    }

    /**
     * Test the central value for the smallest and largest double values.
     * Expected output: (Double.MIN_VALUE + Double.MAX_VALUE) / 2
     */
    @Test
    public void testCentralValueMinMaxDouble() {
        Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
        assertEquals((Double.MIN_VALUE + Double.MAX_VALUE) / 2, range.getCentralValue(), 0.0001);
    }

    /**
     * Test the central value for an extreme range (-Double.MAX_VALUE, Double.MAX_VALUE).
     * Expected output: ( -MAX_VALUE + MAX_VALUE ) / 2 = 0.0
     */
    @Test
    public void testCentralValueExtremeRange() {
        Range range = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals(0.0, range.getCentralValue(), 0.0001);
    }

    /**
     * Test case: Get lower bound of the range.
     * Test strategy: The Javadoc states "Returns the lower bound for the range."
     * Check the lower bound for a known range.
     */
    @Test
    public void lowerBoundShouldBeNegativeOne() {
        assertEquals("Lower bound should be -1", -1, exampleRange.getLowerBound(), .000000001d);
    }
    /**
     * Test the lower bound for a positive range (2,6).
     * Expected output: 2.0
     */
    @Test
    public void testLowerBoundPositiveRange() {
        Range range = new Range(2, 6);
        assertEquals(2.0, range.getLowerBound(), 0.0001);
    }

    /**
     * Test the lower bound for a negative range (-6,-2).
     * Expected output: -6.0
     */
    @Test
    public void testLowerBoundNegativeRange() {
        Range range = new Range(-6, -2);
        assertEquals(-6.0, range.getLowerBound(), 0.0001);
    }

    /**
     * Test the lower bound for a range that crosses zero (-3,3).
     * Expected output: -3.0
     */
    @Test
    public void testLowerBoundCrossingZero() {
        Range range = new Range(-3, 3);
        assertEquals(-3.0, range.getLowerBound(), 0.0001);
    }

    /**
     * Test the lower bound when the lower and upper bounds are the same (5,5).
     * Expected output: 5.0
     */
    @Test
    public void testLowerBoundSameBounds() {
        Range range = new Range(5, 5);
        assertEquals(5.0, range.getLowerBound(), 0.0001);
    }

    /**
     * Test the lower bound for a large range (-1000, 1000).
     * Expected output: -1000.0
     */
    @Test
    public void testLowerBoundLargeRange() {
        Range range = new Range(-1000, 1000);
        assertEquals(-1000.0, range.getLowerBound(), 0.0001);
    }

    /**
     * Test the lower bound for the smallest double value.
     * Expected output: Double.MIN_VALUE
     */
    @Test
    public void testLowerBoundMinValue() {
        Range range = new Range(Double.MIN_VALUE, 1000);
        assertEquals(Double.MIN_VALUE, range.getLowerBound(), 0.0001);
    }


    /**
     * Test the lower bound for an extreme range (-Double.MAX_VALUE, Double.MAX_VALUE).
     * Expected output: -Double.MAX_VALUE
     */
    @Test
    public void testLowerBoundExtremeRange() {
        Range range = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals(-Double.MAX_VALUE, range.getLowerBound(), 0.0001);
    }

    /**
     * Test the lower bound when the range includes negative infinity.
     * Expected output: Double.NEGATIVE_INFINITY
     */
    @Test
    public void testLowerBoundNegativeInfinity() {
        Range range = new Range(Double.NEGATIVE_INFINITY, 1000);
        assertEquals(Double.NEGATIVE_INFINITY, range.getLowerBound(), 0.0001);
    }



    /**
     * Test case: Get upper bound of the range.
     * Test strategy: The Javadoc states "Returns the upper bound for the range."
     * Check the upper bound for a known range.
     */
    @Test
    public void upperBoundShouldBeOne() {
        assertEquals("Upper bound should be 1", 1, exampleRange.getUpperBound(), .000000001d);
    }


    /**
     * Test the upper bound for a positive range (2,6).
     * Expected output: 6.0
     */
    @Test
    public void testUpperBoundPositiveRange() {
        Range range = new Range(2, 6);
        assertEquals(6.0, range.getUpperBound(), 0.0001);
    }

    /**
     * Test the upper bound for a negative range (-6,-2).
     * Expected output: -2.0
     */
    @Test
    public void testUpperBoundNegativeRange() {
        Range range = new Range(-6, -2);
        assertEquals(-2.0, range.getUpperBound(), 0.0001);
    }

    /**
     * Test the upper bound for a range that crosses zero (-3,3).
     * Expected output: 3.0
     */
    @Test
    public void testUpperBoundCrossingZero() {
        Range range = new Range(-3, 3);
        assertEquals(3.0, range.getUpperBound(), 0.0001);
    }

    /**
     * Test the upper bound when the lower and upper bounds are the same (5,5).
     * Expected output: 5.0
     */
    @Test
    public void testUpperBoundSameBounds() {
        Range range = new Range(5, 5);
        assertEquals(5.0, range.getUpperBound(), 0.0001);
    }

    /**
     * Test the upper bound for a large range (-1000, 1000).
     * Expected output: 1000.0
     */
    @Test
    public void testUpperBoundLargeRange() {
        Range range = new Range(-1000, 1000);
        assertEquals(1000.0, range.getUpperBound(), 0.0001);
    }

    /**
     * Test the upper bound for the largest double value.
     * Expected output: Double.MAX_VALUE
     */
    @Test
    public void testUpperBoundMaxValue() {
        Range range = new Range(1, Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, range.getUpperBound(), 0.0001);
    }

    /**
     * Test the upper bound for an extreme range (-Double.MAX_VALUE, Double.MAX_VALUE).
     * Expected output: Double.MAX_VALUE
     */
    @Test
    public void testUpperBoundExtremeRange() {
        Range range = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, range.getUpperBound(), 0.0001);
    }

    /**
     * Test the upper bound when the range includes positive infinity.
     * Expected output: Double.POSITIVE_INFINITY
     */
    @Test
    public void testUpperBoundPositiveInfinity() {
        Range range = new Range(-1000, Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, range.getUpperBound(), 0.0001);
    }

    /**
     * Test case: Range contains a value within the range.
     * Test strategy: The Javadoc states "Returns true if the specified value is within the range and false otherwise."
     * Check if a known range contains a value within its bounds.
     */
    @Test
    public void rangeShouldContainZero() {
        assertTrue("Range should contain 0", exampleRange.contains(0));
    }

    /**
     * Test case: Combine two null ranges.
     * Test strategy: The Javadoc states "either range can be null, in which case the other range is returned; if both ranges are null the return value is null."
     * Combining two null ranges should return null.
     */
    @Test
    public void combiningNullRangesShouldReturnNull() {
        assertNull("Combining null ranges should return null", Range.combine(null, null));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}