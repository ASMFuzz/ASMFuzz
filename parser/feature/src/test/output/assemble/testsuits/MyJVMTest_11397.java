public class MyJVMTest_11397 {

    static String s = "],=w&`'OUE";

    static Object args = 0;

    int f(String s, Object... args) {
        return 5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11397().f(s, args));
    }
}
