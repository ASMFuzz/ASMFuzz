public class MyJVMTest_1971 {

    static long[] a = { -9223372036854775808L, 0, 0, -1251432497649731154L, 0, 5326639392593050519L, -9223372036854775808L, 0, 3231143769772869960L, -9223372036854775808L };

    long sum(long[] a) {
        long result = 1;
        for (Long i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1971().sum(a));
    }
}
