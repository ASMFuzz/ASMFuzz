public class MyJVMTest_15836 {

    static long[] a = { 0, -1860022555966345634L, 675694196867246746L, 9223372036854775807L, 9223372036854775807L, 7068059685522088535L, 9223372036854775807L, -3722555892790131832L, -4378300200247864361L, 9223372036854775807L };

    long sum(long[] a) {
        long sum = 0;
        for (int index = 0; index < a.length; index++) {
            sum += a[index];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15836().sum(a));
    }
}
