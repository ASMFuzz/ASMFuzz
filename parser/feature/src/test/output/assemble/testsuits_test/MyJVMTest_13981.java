public class MyJVMTest_13981 {

    static long[] a = { 9161971928028891122L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, 6552021524391527052L, -2364608167273130755L, 9223372036854775807L, -9223372036854775808L, 0 };

    long checkSum(long[] a) {
        long sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13981().checkSum(a));
    }
}
