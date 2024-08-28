public class MyJVMTest_11209 {

    static long[] a = { 0, -3052870868950924657L, -7868034324166612199L, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 0, 0, -9223372036854775808L };

    long sum(long[] a) {
        long result = 1;
        for (Long i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11209().sum(a));
    }
}
