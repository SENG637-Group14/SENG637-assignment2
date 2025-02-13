package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    @Test
    public void testGetCentralValue() {
        assertEquals("Central value should be 0", 0, exampleRange.getCentralValue(), 0.0000001);
    }
    @Test
    public void testContains() {
        assertTrue("Should contain 0", exampleRange.contains(0));
        assertFalse("Should not contain 2", exampleRange.contains(2));
    }

    @Test
    public void testIntersects() {
        assertTrue("Should intersect with (-2,0)", exampleRange.intersects(-2, 0));
        assertFalse("Should not intersect with (2,3)", exampleRange.intersects(2, 3));
    }
    
    @Test
    public void testExpand() {
        Range expanded = Range.expand(exampleRange, 0.5, 0.5);
        assertEquals("Expanded range should be (-2,2)", new Range(-2, 2), expanded);
    }


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
