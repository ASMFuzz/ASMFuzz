public class MyJVMTest_6356 {

    static long[] a = { 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -6030899336279372045L, 9223372036854775807L, 0 };

    long sum(long[] a) {
        long sum = 0;
        for (int index = 0; index < a.length; index++) {
            sum += a[index];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6356().sum(a));
    }
}
