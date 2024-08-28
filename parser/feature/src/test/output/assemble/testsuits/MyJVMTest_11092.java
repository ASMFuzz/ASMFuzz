public class MyJVMTest_11092 {

    static long count = -9223372036854775808L, maximum = 9223372036854775807L, minimum = -4183242560478252025L, sum = 0, sumOfSquares = -3031078098962319761L;

    static String variableName = " J5;$Ib%,t";

    long getMean() {
        return (count > 0) ? (sum / count) : 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11092().getMean());
    }
}
