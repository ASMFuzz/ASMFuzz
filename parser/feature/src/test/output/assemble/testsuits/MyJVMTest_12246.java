public class MyJVMTest_12246 {

    static long newValue = 6859143864308660527L;

    static long count = 0, maximum = 9223372036854775807L, minimum = 9223372036854775807L, sum = 0, sumOfSquares = 1091168622201458025L;

    static String variableName = "aT qofj'ix";

    long add(long newValue) {
        sum += newValue;
        sumOfSquares += newValue * newValue;
        maximum = java.lang.Math.max(newValue, maximum);
        minimum = java.lang.Math.min(newValue, minimum);
        ++count;
        return newValue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12246().add(newValue);
    }
}
