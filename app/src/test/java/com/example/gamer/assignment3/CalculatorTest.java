package com.example.gamer.assignment3;

/**
 * Created by Gamer on 8/18/2017.
 */

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }
    /**
     * Test for addition with a negative operand
     */
    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }
    /**
     * Test for addition where the result is negative
     */
    @Test
    public void addTwoNumbersWorksWithNegativeResult() {
        double resultAdd = mCalculator.add(-1d, -17d);
        assertThat(resultAdd, is(equalTo(-18d)));
    }
    /**
     * Test for floating-point addition
     */
    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111d, 1.111d);
        assertThat(resultAdd, is(equalTo(2.222)));
    }

    /**
     * Test for especially large numbers
     */
    @Test
    public void addTwoNumbersBignums() {
        double resultAdd = mCalculator.add(123456781d, 111111111d);
        assertThat(resultAdd, is(equalTo(234567892d)));
    }
    /**
     * Test for simple subtraction
     */
    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(1d, 1d);
        assertThat(resultSub, is(equalTo(0d)));
    }

    /**
     * Test for simple subtraction with a negative result
     */
    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(1d, 17d);
        assertThat(resultSub, is(equalTo(-16d)));
    }

    /**
     * Test for simple division
     */
    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(32d,2d);
        assertThat(resultDiv, is(equalTo(16d)));
    }

    /**
     * Test for divide by zero; must throw IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void divDivideByZeroThrows() {
        mCalculator.div(32d,0d);
    }

    /**
     * Test for simple multiplication
     */
    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(32d, 2d);
        assertThat(resultMul, is(equalTo(64d)));
    }

    @Test
    public void powPositiveIntegers() {
        double resultPow = mCalculator.pow(3d, 2d);
        assertThat(resultPow, is(equalTo(9d)));
    }

    @Test
    public void powFirstOperandNeg() {
        double resultPow = mCalculator.pow(-3d, 3d);
        assertThat(resultPow, is(equalTo(-27d)));
    }

    @Test
    public void powSecondOperandNeg() throws Exception{
        double resultPow = mCalculator.pow(3d, -5d);
        assertThat(resultPow, is(closeTo(0.00411d, 0.001)));
    }

    @Test
    public void powFirstOperandZero() {
        double resultPow = mCalculator.pow(0d, 3d);
        assertThat(resultPow, is(equalTo(0d)));
    }

    @Test
    public void powSecondOperandZero() {
        double resultPow = mCalculator.pow(3d, 0d);
        assertThat(resultPow, is(equalTo(1d)));
    }

    @Test
    public void powFirstOperandZeroSecondOperandMinusOne() {
        double resultPow = mCalculator.pow(0d, -1d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powFirstOperandMinusZeroSecondOperandNeg() {
        double resultPow = mCalculator.pow(-0d, -2d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}
