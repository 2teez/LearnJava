package com.practice.arrayprints;

import static com.practice.jutils.Jutils.utils;

import com.practice.jutils.Jutils.utils;
import java.util.Arrays;

class ArrayPrints {

    public static void main(String[] args) throws Exception {
        final double[] costs = { 2, 7, 3 };
        utils.prints(utils.sum(costs) / costs.length);
        final String[] ws = { "World", "Wars", "Warriors" };
        utils.prints("Hello, ", ws);
        utils.prints(new String[] { "values", "votes", "varaibles.." });
        //
        // use remDivide method
        var myTuple = ArrayPrints.tuple(13, 4);
        utils.prints(
            "Reminder and divide: ",
            Arrays.toString(
                remDivide(myTuple.getNumber(0), myTuple.getNumber(1))
            )
        );
    }

    static Tupler tuple(int... args) {
        class Tuple implements Tupler {

            private final int[] values = new int[2];

            public Tuple(int... args) {
                values[0] = args[0];
                values[1] = args[1];
            }

            @Override
            public int getNumber(int index)
                throws ArrayIndexOutOfBoundsException {
                if (index > 1 || index < 0) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                return this.values[index];
            }
        }
        return new Tuple(args);
    }

    static int[] remDivide(int firstNumber, int secondNumber)
        throws ArithmeticException {
        if (secondNumber == 0) {
            throw new ArithmeticException("Can't divide with Zero.");
        }

        return new int[] {
            firstNumber % secondNumber,
            firstNumber / secondNumber,
        };
    }
}

interface Tupler {
    int getNumber(int index) throws ArrayIndexOutOfBoundsException;
}
