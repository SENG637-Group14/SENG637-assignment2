package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;

    @Before
    public void setUp() {
        exampleRange = new Range(-1, 1); // Setting up a default range
    }

    // -------------- Central Value Tests --------------
    
    @Test // Test if the central value is correctly calculated for a range crossing zero
    public void testCentralValueZero() {
        assertEquals(0, exampleRange.getCentralValue(), 0.000000001);
    }

    @Test // Test the central value for a positive range
    public void testCentralValuePositiveRange() {
        assertEquals(4.0, new Range(2, 6).getCentralValue(), 0.0001);
    }

    @Test // Test the central value for a negative range
    public void testCentralValueNegativeRange() {
        assertEquals(-4.0, new Range(-6, -2).getCentralValue(), 0.0001);
    }

    @Test // Test when both bounds are the same
    public void testCentralValueSameBounds() {
        assertEquals(5.0, new Range(5, 5).getCentralValue(), 0.0001);
    }

    // -------------- Lower Bound Tests --------------
    
    @Test // Test lower bound of default range
    public void testLowerBoundNegativeOne() {
        assertEquals(-1, exampleRange.getLowerBound(), 0.000000001);
    }

    @Test // Test lower bound of a positive range
    public void testLowerBoundPositiveRange() {
        assertEquals(2.0, new Range(2, 6).getLowerBound(), 0.0001);
    }

    @Test // Test lower bound for an extreme range with max negative value
    public void testLowerBoundExtremeRange() {
        assertEquals(-Double.MAX_VALUE, new Range(-Double.MAX_VALUE, Double.MAX_VALUE).getLowerBound(), 0.0001);
    }

    // -------------- Upper Bound Tests --------------
    
    @Test // Test upper bound of default range
    public void testUpperBoundOne() {
        assertEquals(1, exampleRange.getUpperBound(), 0.000000001);
    }

    @Test // Test upper bound of a positive range
    public void testUpperBoundPositiveRange() {
        assertEquals(6.0, new Range(2, 6).getUpperBound(), 0.0001);
    }

    @Test // Test upper bound with positive infinity
    public void testUpperBoundPositiveInfinity() {
        assertEquals(Double.POSITIVE_INFINITY, new Range(-1000, Double.POSITIVE_INFINITY).getUpperBound(), 0.0001);
    }

    // -------------- Contains Method Tests --------------
    
    @Test // Test if the range contains zero
    public void testRangeContainsZero() {
        assertTrue(exampleRange.contains(0));
    }

    @Test // Test if the range contains a value within its bounds
    public void testRangeContainsValueWithin() {
        assertTrue(new Range(-5, 5).contains(3));
    }

    @Test // Test if the range does not contain a value outside its bounds
    public void testRangeDoesNotContainValue() {
        assertFalse(new Range(1, 10).contains(-1));
    }

    // -------------- Combine Method Tests --------------
    
    @Test // Test combining two null ranges should return null
    public void testCombineNullRanges() {
        assertNull(Range.combine(null, null));
    }

    @Test // Test combining a null range with a valid range should return the valid range
    public void testCombineOneNullRange() {
        Range range = new Range(1, 10);
        assertEquals(range, Range.combine(range, null));
    }
}
