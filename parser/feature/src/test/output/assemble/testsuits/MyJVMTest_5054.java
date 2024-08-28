public class MyJVMTest_5054 {

    int returnOne() {
        try {
            return 1 / 0;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5054().returnOne());
    }
}
