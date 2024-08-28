public class MyJVMTest_10355 {

    static int i = 0;

    static long f0 = 207221829471568819L, f1 = 9223372036854775807L;

    static long sf0 = 4647492539643497468L, sf1 = -9223372036854775808L;

    Object getStatic(int i) {
        return new long[] { sf0, sf1 }[i];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10355().getStatic(i));
    }
}
