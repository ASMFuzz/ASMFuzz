public class MyJVMTest_6282 {

    static boolean trap = false;

    boolean m2(boolean trap) {
        if (trap) {
            new B();
        }
        return trap;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6282().m2(trap);
    }
}
