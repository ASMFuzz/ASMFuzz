public class MyJVMTest_2321 {

    static long[] a = { 0, 876078019032601942L, 1549304014889079530L, -9223372036854775808L, 0, -9223372036854775808L, -591921285048320082L, 0, 0, -9223372036854775808L };

    long sumb(long[] a) {
        Long result = 1l;
        for (Long i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2321().sumb(a));
    }
}
