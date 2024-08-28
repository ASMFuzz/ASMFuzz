public class MyJVMTest_2944 {

    static long newValue = -9223372036854775808L;

    static long count = 9223372036854775807L, maximum = 0, minimum = -9223372036854775808L, sum = -6542064459287339882L, sumOfSquares = 0;

    static String variableName = "!S%dG2T+14";

    long add(long newValue) {
        sum += newValue;
        sumOfSquares += newValue * newValue;
        maximum = java.lang.Math.max(newValue, maximum);
        minimum = java.lang.Math.min(newValue, minimum);
        ++count;
        return newValue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2944().add(newValue);
    }
}
