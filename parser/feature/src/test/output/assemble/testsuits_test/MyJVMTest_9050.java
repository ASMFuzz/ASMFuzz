public class MyJVMTest_9050 {

    static long[] a = { 5714585374678677876L, -9223372036854775808L, 8075975638964764996L, 0, -9223372036854775808L, 0, 9223372036854775807L, 0, 9223372036854775807L, 0 };

    long checkSum(long[] a) {
        long sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9050().checkSum(a));
    }
}
