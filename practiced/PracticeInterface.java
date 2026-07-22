package com.practice.practiceinterface;

import static java.lang.System.out;

interface IntSequence {
    boolean hasNext();
    int next();
}

class PracticeInterface {

    public static void main(String[] args) {
        IntSequence intSeq = new SquareSequence();
        var avg = getAvearge(intSeq, 100);
        out.println(avg);
        //
        IntSequence digSeq = new DigitSequence(1978);
        var digAvg = getAverage(digSeq, 100);
        out.println(digAvg);
    }

    static double getAverage(IntSequence seq, int n) {
        int count = 0;
        double sum = 0;
        while (seq.hasNext() && count < n) {
            sum += seq.next();
            count++;
        }
        return sum/count;
    }
}

class SquareSequence implements IntSequence {
    private int number;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int next() {
        number++;
        return number * number;
    }
}
class DigitSequence implements IntSequence {
    private int digits;
    DigitSequence(int digits) {
        this.digits = digits;
    }

    @Override
    public boolean hasNext() {
        return this.digits != 0;
    }

    @Override
    public int next() {
        int result = this.digits % 10;
        this.digits /= 10;
        return result;
    }

    public int rest() {
        return number;
    }
}
