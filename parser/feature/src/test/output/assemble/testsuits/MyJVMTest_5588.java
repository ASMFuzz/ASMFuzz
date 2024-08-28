public class MyJVMTest_5588 {

    static long[] a = { 3083357068025491152L, 6022592109445546924L, 0, 2988539238953420478L, -5839111976562604066L, 0, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    long summ2(long[] a) {
        Long result1 = 1l;
        Long result2 = new Long(1);
        for (Long i : a) {
            result1 += i;
            result2 += new Long(i + 1);
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5588().summ2(a));
    }
}
