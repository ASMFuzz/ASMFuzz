public class MyJVMTest_14061 {

    static long[] o = { 0, 4920676009643281987L, 0, 9223372036854775807L, 9223372036854775807L, 8044219823388858373L, -2793564005913997031L, 3883114723340907431L, -3132185180649462724L, -9223372036854775808L };

    static int nonStaticPublicField = -989223890;

    static int nonStaticFinalPublicField = 6;

    int getLength(long[] o) {
        return o.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14061().getLength(o));
    }
}
