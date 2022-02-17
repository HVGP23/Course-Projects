package Timer;

/* *********************************************************************
 * The GeoCountDownTimerTest tests the GeoCountDownTimer class
 *
 * @author Hector Garcia
 * @version February 1, 2022
 *
 ********************************************************************* */

import org.junit.Test;
import static org.junit.Assert.*;

public class GeoCountDownTimerTest {
    @Test
    public void constructorTest1() {
        GeoCountDownTimer test = new GeoCountDownTimer(2, 28, 2022);
        assertEquals(test.toDateString(), "2/28/2022");

        test = new GeoCountDownTimer(5, 31, 2022);
        assertEquals(test.toString(), "May 31, 2022");

        test = new GeoCountDownTimer(2, 29, 2024);
        assertEquals(test.toString(), "February 29, 2024");

        test = new GeoCountDownTimer(9, 29, 2135);
        assertEquals(test.toString(), "September 29, 2135");
    }

    @Test
    public void constructorTest2() {
        GeoCountDownTimer test = new GeoCountDownTimer();
        assertEquals(test.toString(), "January 1, 2022");
    }

    @Test
    public void constructorTest3() {
        GeoCountDownTimer test = new GeoCountDownTimer("1/31/2022");
        assertEquals((test.toDateString()), "1/31/2022");

        test = new GeoCountDownTimer("9/30/2123");
        assertEquals((test.toDateString()), "9/30/2123");

        test = new GeoCountDownTimer("2/28/2022");
        assertEquals((test.toDateString()), "2/28/2022");

        test = new GeoCountDownTimer("2/29/2024");
        assertEquals((test.toDateString()), "2/29/2024");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor5() {
        GeoCountDownTimer s = new GeoCountDownTimer(2, 29, 2121);
        assertTrue(s.toDateString().equals("2/29/2020"));

        s = new GeoCountDownTimer(1, 31, 2121);
        assertTrue(s.toDateString().equals("1/31/1290"));

        s = new GeoCountDownTimer(1, 32, 2121);
        assertTrue(s.toDateString().equals("1/32/2121"));
    }

    @Test
    public void decTest() {
        GeoCountDownTimer test = new GeoCountDownTimer(1, 31, 2022);
        test.dec(1);
        System.out.println("The date is: " + test);

        GeoCountDownTimer test2 = new GeoCountDownTimer(1, 31, 2022);
        test2.dec(10);
        System.out.println("The date is: " + test2.toDateString());

        GeoCountDownTimer test3 = new GeoCountDownTimer(1, 31, 2022);
        test3.dec(100);
        System.out.println("The date is: " + test3);

        GeoCountDownTimer test4 = new GeoCountDownTimer(1, 31, 2022);
        test4.dec(365);
        System.out.println("The date is: " + test4.toDateString());

        GeoCountDownTimer test5 = new GeoCountDownTimer(1, 31, 2022);
        test5.dec(1460);
        System.out.println("The date is: " + test5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstuctor1() {
        new GeoCountDownTimer(2, -3, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstuctor2() {
        new GeoCountDownTimer(2, 29, 2022);
    }

    @Test
    public void incTest() {
        GeoCountDownTimer test = new GeoCountDownTimer(1, 31, 2022);
        test.inc();
        System.out.println("The date is: " + test);

        GeoCountDownTimer test2 = new GeoCountDownTimer(1, 31, 2022);
        test2.inc(10);
        System.out.println("The date is: " + test2.toDateString());

        GeoCountDownTimer test3 = new GeoCountDownTimer(1, 31, 2022);
        test3.inc(100);
        System.out.println("The date is: " + test3);

        GeoCountDownTimer test4 = new GeoCountDownTimer(1, 31, 2022);
        test4.inc(365);
        System.out.println("The date is: " + test4.toDateString());

        GeoCountDownTimer test5 = new GeoCountDownTimer(1, 31, 2022);
        test5.inc(1460);
        System.out.println("The date is: " + test5);


        GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2122);
        s1.inc(365);
        System.out.println(s1);
        assertTrue(s1.toDateString().equals("5/10/2123"));

        s1 = new GeoCountDownTimer(1, 10, 2121);

        for (int i = 0; i < 366; i++)
            s1.inc();
        assertTrue(s1.toDateString().equals("1/11/2122"));

        s1 = new GeoCountDownTimer(5, 10, 2022);

        for (int i = 0; i < 31665; i++)
            s1.inc();

        for (int i = 0; i < 31665; i++)
            s1.dec();

        assertTrue(s1.toDateString().equals("5/10/2022"));
    }

    @Test
    public void daysToGoTest() {
        GeoCountDownTimer test = new GeoCountDownTimer(1, 30, 2022);
        System.out.println("Days to go is: " + test.daysToGo("1/30/2022"));

        test = new GeoCountDownTimer(1, 31, 2022);
        System.out.println("Days to go is: " + test.daysToGo("5/30/2023"));
        assertEquals(-484, test.daysToGo("5/30/2023"));

        GeoCountDownTimer test2 = new GeoCountDownTimer(1, 30, 2022);
        System.out.println("Days to go is: " + test2.daysToGo("5/30/2023"));
        assertEquals(-485, test2.daysToGo("5/30/2023"));

        GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2121);
        System.out.println("Days to go is: " + s1.daysToGo("2/1/2121"));
        assertEquals(8, s1.daysToGo("2/1/2121"));

        assertEquals(1, s1.daysToGo("2/8/2121"));
        assertEquals(0, s1.daysToGo("2/9/2121"));
    }

    @Test
    public void dayInFutureTest() {
        GeoCountDownTimer test = new GeoCountDownTimer(1, 30, 2022);

        System.out.println(test.daysInFuture(20));
        System.out.println(test.daysInFuture(365));
        System.out.println(test.daysInFuture(-20));
        System.out.println(test.daysInFuture(-365));
    }

    @Test
    public void testEqual() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
        GeoCountDownTimer s2 = new GeoCountDownTimer(6, 1, 2121);
        GeoCountDownTimer s3 = new GeoCountDownTimer(5, 5, 2121);
        GeoCountDownTimer s4 = new GeoCountDownTimer(5, 9, 3000);
        GeoCountDownTimer s5 = new GeoCountDownTimer(5, 9, 3000);

        assertEquals(s4, s5);
        assertNotEquals(s1, s2);
        assertNotEquals(s3, s4);
        assertEquals(s1, s4);
    }

    @Test
    public void testCompareTo() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 2121);
        GeoCountDownTimer s2 = new GeoCountDownTimer(6, 1, 2121);
        GeoCountDownTimer s3 = new GeoCountDownTimer(5, 8, 2121);
        GeoCountDownTimer s4 = new GeoCountDownTimer(5, 9, 2121);

        assertTrue(s2.compareTo(s1) > 0);
        assertTrue(s3.compareTo(s1) < 0);
        assertEquals(0, s1.compareTo(s4));
    }

    @Test
    public void testLoadSave() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(1, 9, 2121);
        GeoCountDownTimer s2 = new GeoCountDownTimer(1, 9, 2121);

        s1.save("file1.txt");
        s1 = new GeoCountDownTimer(1, 10, 2121);
        s1.load("file1.txt");
        assertTrue(s2.equals(s1));
    }
}