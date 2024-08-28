public class MyJVMTest_11581 {

    static long[] a = { -4403444648000846531L, 1227086184988869908L, -466731135546381281L, -8368357246555223167L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -2856782680857482552L, -9223372036854775808L, 0 };

    long sumb(long[] a) {
        Long result = 1l;
        for (Long i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11581().sumb(a));
    }
}
