public class MyJVMTest_4942 {

    static String a = "aO#2,yS51I";

    static String b = "(<}SGKaowE";

    static int v = 1312878340;

    static int expected = 809112670;

    static long start = 9223372036854775807L;

    static int ITERATIONS = 100000;

    int test_end(String a, String b, int v, int expected, long start) {
        long end = System.currentTimeMillis();
        int res = (v / ITERATIONS);
        System.out.print(" " + res);
        System.out.println(" time:" + (end - start));
        if (res != expected) {
            System.out.println("wrong indexOf result: " + res + ", expected " + expected);
            System.out.println("\"" + b + "\".indexOf(\"" + a + "\")");
            System.exit(97);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4942().test_end(a, b, v, expected, start);
    }
}
