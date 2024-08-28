public class MyJVMTest_15759 {

    static boolean trap = false;

    boolean m2(boolean trap) {
        if (trap) {
            new B();
        }
        return trap;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15759().m2(trap);
    }
}
