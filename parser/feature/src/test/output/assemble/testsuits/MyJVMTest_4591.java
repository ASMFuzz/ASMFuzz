public class MyJVMTest_4591 {

    static long[] a = { -2627232728866351550L, 9223372036854775807L, 286813910409769504L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -107758777194456156L, -9223372036854775808L, -6696047227221537065L, 0 };

    long checkSum(long[] a) {
        long sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4591().checkSum(a));
    }
}
