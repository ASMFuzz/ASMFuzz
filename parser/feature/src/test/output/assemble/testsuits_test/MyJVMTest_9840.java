public class MyJVMTest_9840 {

    static boolean h_passed = false;

    static boolean v_passed = false;

    boolean isPassed() {
        return h_passed && v_passed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9840().isPassed());
    }
}
