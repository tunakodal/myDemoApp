package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    @org.junit.Test
    public void testGenerated() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        assertNotNull(new App().password_generator("Hello", "World" , array1 , array2,  7));
    }
    @org.junit.Test
    public void testInsufficientPasswordLength() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        assertNull(new App().password_generator("Hello", "World" , array1 , array2, 5));
    }
    @org.junit.Test
    public void testEmptyArray() {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        assertNull(new App().password_generator("Hello", "World" , array1 , array2, 8));
    }
    @org.junit.Test
    public void testInsufficientArrayLength() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2));
        assertNull(new App().password_generator("Hello", "World" , array1 , array2, 8));
    }

    @org.junit.Test
    public void testArrayLengthNotEqual() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertNull(new App().password_generator("Hello", "World" , array1 , array2, 10));
    }

}
