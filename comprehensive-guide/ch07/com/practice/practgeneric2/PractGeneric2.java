package com.practice.practgeneric2;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

class PractGeneric2 {

    public static void main(String[] args) {
        var stringWrapper = new Wrapper<String>("howdy");
        WrapperUtil.printDetails(stringWrapper);
        var numberListWrapper = new Wrapper<List<Integer>>(
            new ArrayList<Integer>()
        );
        numberListWrapper.set(List.of(3, 6, 8));
        WrapperUtil.printDetails(numberListWrapper);
        //
        WrapperUtil.printDetails(numberListWrapper);
    }
}

class Wrapper<T> {

    private T ref;

    public Wrapper(T ref) {
        set(ref);
    }

    public void set(T ref) {
        this.ref = ref;
    }

    public T get() {
        return this.ref;
    }

    @Override
    public String toString() {
        return String.format("%s", ref);
    }
}

class WrapperUtil {

    public static void printDetails(Wrapper<?> value) {
        out.println(value);
    }
}
