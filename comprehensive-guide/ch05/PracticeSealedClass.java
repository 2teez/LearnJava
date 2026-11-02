package com.practice.practicesealedclass;

class PracticeSealedClass {

    public static void main(String[] args) {
        var num = 42;
        Result result = switch (num) {
            case 42 -> new Success("Lucky Age...");
            default -> new Failure(900, "Can't be Metuzsela");
        };
        System.out.println(result.value);
    }
}

abstract sealed class Result permits Failure, Success {

    final Object value;

    Result(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "%s: (%s)".format(this.getClass().getSimpleName(), this.value);
    }
}

final class Success extends Result {

    Success(Object value) {
        super(value);
    }
}

final class Failure extends Result {

    final int errCode;

    Failure(int errCode, Object value) {
        super(value);
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return "%s: (%d), %s".format(
            this.getClass().getSimpleName(),
            this.value,
            this.errCode
        );
    }
}
