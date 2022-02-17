package Timer;

/* *********************************************************************
 * The GeoCountDownTimer class provides various methods to manipulate
 * dates in a calendar. The user will be able to increment, decrement,
 * showcase dates in various ways.
 *
 * @author Hector Garcia
 * @version February 1, 2022
 *
 ********************************************************************* */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GeoCountDownTimer {

    /** The integer instance variable month holds the month value */
    private int month;

    /** The integer instance variable year holds the year value */
    private int year;

    /** The integer instance variable day holds the day value */
    private int day;

    /** The static final integer variable MIN_YEAR holds the minimum year of 2022 */
    private static final int MIN_YEAR = 2022;

    /** The static final integer variable JAN holds the value 1 */
    private static final int JAN = 1;

    /** The static final integer variable JAN holds the value 1 */
    private static final int FEB = 2;

    /** The static final integer variable APR holds the value 4 */
    private static final int APR = 4;

    /** The static final integer variable JUN holds the value 6 */
    private static final int JUN = 6;

    /** The static final integer variable SEP holds the value 9 */
    private static final int SEP = 9;

    /** The static final integer variable NOV holds the value 11 */
    private static final int NOV = 11;

    /** The static final integer variable DEC holds the value 12 */
    private static final int DEC = 12;

    /**
     * The instance variable remainingDays keeps track of the remaining days when
     * subtracting or incrementing the date by x amount days
     */
    int remainingDays;

    /** a String ArrayList that holds the name for each month */
    private static final ArrayList<String> months = new ArrayList<>(
            Arrays.asList(" ", "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"));

    /*
     * The GeoCountDownTimer constructor with no parameters, and initializes the
     * instance variables: month to 1, the day to 1, and the year to 2022
     */
    public GeoCountDownTimer() {
        // set instance variable month to January
        this.month = JAN;

        // set instance variable day to 1
        this.day = 1;

        // set instance variable year to 2022
        this.year = MIN_YEAR;
    }

    /*
     * The GeoCountDownTimer constructor takes the following parameters:
     * year, month and day and assigns them to the class' instance variables year,
     * month, and day.
     *
     * @param month, day, and year
     * @return none
     */
    public GeoCountDownTimer(int month, int day, int year) {
        // check for valid dates
        if ( (month > 0 && month < 13) && (day > 0 && day < 32) && (year >= 2022) ) {
            if (month == 2) {
                if (isLeapYear(year) && (day < 30)) {
                    // set instance variable year to the given value from parameter
                    this.year = year;

                    // set instance variable month to the given value from parameter
                    this.month = month;

                    // set instance variable day to the given value from parameter
                    this.day = day;

                } else if (!isLeapYear(year) && (day < 29)) {

                    // set instance variable year to the given value from parameter
                    this.year = year;

                    // set instance variable month to the given value from parameter
                    this.month = month;

                    // set instance variable day to the given value from parameter
                    this.day = day;

                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                // set instance variable year to the given value from parameter
                this.year = year;

                // set instance variable month to the given value from parameter
                this.month = month;

                // set instance variable day to the given value from parameter
                this.day = day;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /*
     * The GeoCountDownTimer constructor initializes the instance variables with the GeoCountDownTime
     * other variables values
     *
     * @param other the other variable is of type GeoCountDownTimer
     * @return none
     */
    public GeoCountDownTimer(GeoCountDownTimer other) {
        // set instance variable year is given the year value from the other variable
        this.year = other.getYear();

        // set instance variable month is given the month value from the other variable
        this.month = other.getMonth();

        // set instance variable day is given the day value from the other variable
        this.day = other.getDay();
    }

    /*
     * The equals() function typecasts an Object other to the type GeoCountDownTimer and verifies that it is
     * equal to the respective instance variable
     *
     * @param other an object of the type Object
     * @return returns true if all variable values match
     */
    public boolean equals(Object other) {

        // type cast the parameter to GeoCountDownTimer object and assign to the GeoCountDownTimer variable tmp
        GeoCountDownTimer tmp = new GeoCountDownTimer((GeoCountDownTimer) other);

        return this.year == tmp.getYear() && this.month == tmp.getMonth() && this.day == tmp.getDay();
    }

    /*
     * The compareTo() function
     *
     * @param other An object of the type GeoCountDownTimer
     * @return 0 when all the instance variables are equal; to
     */
    public int compareTo(GeoCountDownTimer other) {

        // if the dates are equal return 0
        if (this.equals(other)) {
            return 0;
            // return 1 if this.year is greater than other.year
        } else if (this.getYear() > other.getYear()) {
            return 1;
            // return -1 if this.year is less than other.year
        } else if (this.getYear() < other.getYear()) {
            return -1;
            // return 1 if this.month is greater than other.month
        } else if (this.getMonth() > other.getMonth()) {
            return 1;
            // return -1 if this.month is less than other.month
        } else if (this.getMonth() < other.getMonth()) {
            return -1;
            // return 1 if this.day is greater than other.day
        } else if (this.getDay() > other.getDay()) {
            return 1;
            // return -1 if this.day is less than other.day
        } else {
            return -1;
        }
    }

    /*
     * The GeoCountDownTimer constructor accepts a string as a parameter with the following
     * format: "5/10/2019" where 5 indicates the month, 10 indicates the day, and 2019 indicates
     * the year
     *
     * The Scanner methods are used to delimit the string being passed in and assigns the instance
     * variables with their respective values
     *
     * @param String geoDate
     * @return none
     */
    public GeoCountDownTimer(String geoDate) {
        // new Scanner object
        Scanner scnr = new Scanner(geoDate);

        // the delimiter is the forward slash "/ | "
        scnr.useDelimiter("/| ");

        // assign month value to m
        int m = scnr.nextInt();
        // assign to day value to d
        int d = scnr.nextInt();
        // assign to year value to y
        int y = scnr.nextInt();

        // check for valid dates
        if ( (m > 0 && m < 13) && (d > 0 && d < 32) && (y >= 2022) ) {
            if (m == 2) {
                if (isLeapYear(y) && (d < 30)) {
                    // set instance variable year to the given value from parameter
                    this.year = y;

                    // set instance variable month to the given value from parameter
                    this.month = m;

                    // set instance variable day to the given value from parameter
                    this.day = d;

                } else if (!isLeapYear(y) && (d < 29)) {

                    // set instance variable year to the given value from parameter
                    this.year = y;

                    // set instance variable month to the given value from parameter
                    this.month = m;

                    // set instance variable day to the given value from parameter
                    this.day = d;

                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                // set instance variable year to the given value from parameter
                this.year = y;

                // set instance variable month to the given value from parameter
                this.month = m;

                // set instance variable day to the given value from parameter
                this.day = d;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /*
     * The dec() method subtracts the number of days from "this" GeoCountDownTimer object. The method
     * will adjust the timer date to the number of days given
     *
     * @param days
     * @return none
     */
    public void dec(int days) {
        // if the current day is greater than days, we can simply subtract the current day value to the days
        // passed in
        if (this.getDay() > days) {

            this.setDay(this.getDay() - days);

        } else if (this.getDay() <= days) {

            // check if it is January b/c year would change
            // check if it is March b/c we will need to check if it is a leap year
            // to give February the right amount of days
            if (this.getMonth() == JAN) {
                // decrement the year
                this.setYear(this.getYear() - 1);

                // set month to December
                this.setMonth(DEC);

                // update remainingDays
                remainingDays = days - this.getDay();

                // set the month's day to the max value
                this.setDay(maxDay(this.getMonth(), this.getYear()));

                // recursive, continues until we get to the first if statement
                dec(remainingDays);
            } else {
                // update the month
                this.setMonth(this.getMonth() - 1);

                // update remainingDays
                remainingDays = days - this.getDay();

                // set the month's day to the max value
                this.setDay(maxDay(this.getMonth(), this.getYear()));

                // recursive, continues until we get to the first if statement
                dec(remainingDays);
            }
        }
    }

    /*
     * The dec() method subtracts the number of days from "this" GeoCountDownTimer object. The method
     * will adjust the timer date down the number of days
     */
    public void dec() {
        this.dec(1);
    }

    /*
     * The inc() method adds the number of days from "this" GeoCountDownTimer object. The method
     * will adjust the timer date to the number of days given
     *
     * @param days is an integer value
     * @return none
     */
    public void inc(int days) {

        // totalDays is the some of the parameter and the current day value
        int totalDays = days + this.getDay();

        // if totalDays is less than the max amount of days in the current month,
        // we will simply add the parameter value to the current day value
        if (totalDays <= maxDay(this.getMonth(), this.getYear())) {
            this.setDay(this.getDay() + days);
        } else {
            // check if it is January b/c year would change
            // check if it is March b/c we will need to check if it is a leap year
            // to give February the right amount of days
            if (this.getMonth() == DEC) {
                // increment the year
                this.setYear(this.getYear() + 1);
                // set month the month
                this.setMonth(JAN);

                if (days <= totalDays) {
                    remainingDays = totalDays - maxDay(this.getMonth(), this.getYear());
                    // set the Day to 0
                    this.setDay(0);
                    // recursive, we will pass in the remainingDays value to the inc() method
                    inc(remainingDays);
                } else {
                    this.setDay(this.getDay() + days);
                }
            } else {
                if (days <= totalDays) {
                    remainingDays = totalDays - maxDay(this.getMonth(), this.getYear());
                    this.setDay(0);
                    this.setMonth(this.getMonth() + 1);
                    inc(remainingDays);
                } else {
                    this.setDay(this.getDay() + days);
                }
            }
        }
    }

    /*
     * The inc() method increments the this.day by 1
     *
     * @param none
     * @return none
     */
    public void inc() {
        this.inc(1);
    }

    /*
     * The toString() method returns the specified date to the following format
     * Month Day, Year
     *
     * e.g. February 12, 2023
     *
     * @param none
     * @return returns the specified date to the following format
     * Month Day, Year
     */
    public String toString() {
        return months.get(this.getMonth()) + " " + this.getDay()
                + ", " + this.getYear();
    }

    /*
     * The toDateString() method returns the specified date to the following format
     * Month/Day/Year
     *
     * e.g. 2/12/2023
     *
     * @param none
     * @return returns the specified date to the following format
     * Month/Day/Year
     */
    public String toDateString() {
        return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
    }

    /*
     * The maxDay() method returns the max value of days in the specific month
     *
     * @param month, year we pass in the value of the month and the year
     * @return Return 30 if month is 4, 6, 9, or 11, return 29 if month is 2
     * and it is leap  yeaer, return 28 if month is 2 and it is not leap year,
     * and return 31 if it is any other month
     */
    public int maxDay(int month, int year) {
        // if the month is April, June, September, or November return 30
        if (month == APR || month == JUN || month == SEP || month == NOV) {
            return 30;
            // if the month is February
        } else if (month == FEB) {
            // if it is leap year return 29
            if (isLeapYear(year)) {
                return 29;
                // return 28 if it is not leap year
            } else {
                return 28;
            }
            // every other month return 31
        } else {
            return 31;
        }
    }

    /*
     * The save() saves the date to a file
     *
     * @param String filename this is the name of the file we are saving to
     * @ return none
     */
    public void save(String filename) {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            String s = this.getMonth() + " " + this.getDay() + " " + this.getYear() + " ";
            out.println(s);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * The load() method loads the information from a file and delimits the information and stores
     * the data in the respective variable
     *
     * @param String filename this is the name of the file
     * @return none
     */
    public void load(String filename){
        // new Scanner object
        Scanner scnr;
        try{
            // open the File
            File f = new File(filename);
            scnr = new Scanner(f);

            scnr.useDelimiter(" ");
            month       = scnr.nextInt();
            day         = scnr.nextInt();
            year        = scnr.nextInt();

            // Could not find file OR failed to read
        } catch(IOException e) {
            System.out.println("Failed to read the data file: " +
                    filename);
        }
    }

    /*
     * The daysToGo function calculates the difference between this.date and the date
     * entered
     *
     * @param String fromDate this is the date being compared to this.date
     * @return count or 0 The count variable keep track of the amount of times the dec() or inc()
     * methods are called, this reflects the difference in the two days. If there is no difference,
     * then the function returns 0
     */
    public int daysToGo(String fromDate) {

        // keeps track of the amount of times either inc() or dec() which reflects the difference between both dates
        int count = 0;
        // new Scanner objects that stores the string value to scnr
        Scanner scnr =  new Scanner(fromDate);
        // delimit the information in scnr by the / symbol
        scnr.useDelimiter("/");
        // assign the first value to month
        int m   = scnr.nextInt();
        // assign the second value to day
        int d   = scnr.nextInt();
        // assign the third value to year
        int y   = scnr.nextInt();

        // create a new GeoCountDownTimer variable and set the respective information based on the information received
        // from scnr
        GeoCountDownTimer tmp = new GeoCountDownTimer(m, d, y);

        // if this date is greater than other date, compareTo returns a 1
        if (this.compareTo(tmp) == 1) {
            // decrement until we reach the other date
            while (!this.equals(tmp)) {
                // count keeps track of the number of days between the two dates
                count++;
                // decrement one day at a time
                tmp.inc();
            }
            return count;
            // if this date is less than other date, compareTo returns a -1
        } else if (this.compareTo(tmp) == -1) {
            // increment until we reach the other date
            while (!this.equals(tmp)) {
                count++;
                tmp.dec();
            }
            return -1 * count;
        } else {
            return 0;
        }
    }

    /*
     * The daysInFuture method returns a GeoCountDownTimer given a number of days in the future.
     * If a value of days is entered that is less than 0, a GeoCountDownTime is returned with the respective
     * past date
     *
     * @param int days This is the value that will be incremented or decremented the GeoCountDownTimer object
     * @return tmp The tmp GeoCountDownTimer is the date that was either incremented or decremented by the # of
     * days passed in
     */
    public GeoCountDownTimer daysInFuture(int days) {
        // create a new GeoCountDownTimer with the current set date
        GeoCountDownTimer tmp = new GeoCountDownTimer(this.getMonth(), this.getDay(), this.getYear());
        // if days is greater than 0 than increment by the # of days
        if (days > 0) {
            tmp.inc(days);
            return tmp;
            // if days is less than 0 than decrement by the # of days
        } else {
            tmp.dec(days * -1);
            return tmp;
        }
    }

    /*
     * The getYear() Method returns the year
     *
     * @param none
     * @return year This method returns the year
     */
    public int getYear() {
        return year;
    }

    /*
     * The setMonth method sets the month
     *
     * @param none
     * @return none
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /*
     * The setYear method sets the year
     *
     * @param none
     * @return none
     */
    public void setYear(int year) {
        this.year = year;
    }

    /*
     * The getMonth method returns the month
     *
     * @param none
     * @return month This method returns the month
     */
    public int getMonth() {
        return month;
    }

    /*
     * The getDay method returns the day
     *
     * @param none
     * @return day This method returns the day
     */
    public int getDay() {
        return day;
    }

    /*
     * The setDay method sets the day
     *
     * @param int day This is the value the day is being set to
     * @return none
     */
    public void setDay(int day) {
        this.day = day;
    }

    /*
     * The isLeapYear() function verifies that the year is in fact a leap year
     *
     * Obtained the isLeapYear from stackOverflow
     *
     * @param int year This is the value being checked if it is a leap year
     * @return false if the year has a remainder of 0 when divided by 4, return true
     * if the remainder equals 0 when dividing the year by 400
     */
    public static boolean isLeapYear(int year) {
        // a leap year occurs every 4 years
        if (year % 4 != 0) {
            return false;
            // we add a leap year every 400 years
        } else if (year % 400 == 0) {
            return true;
            // we remove a leap year every 100 years
        } else return year % 100 != 0;
    }
}