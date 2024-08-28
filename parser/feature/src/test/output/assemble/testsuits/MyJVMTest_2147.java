public class MyJVMTest_2147 {

    static String s = "9_K.`/AZ[Q";

    static Object args = 0;

    int f(String s, Object... args) {
        return 5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2147().f(s, args));
    }
}
