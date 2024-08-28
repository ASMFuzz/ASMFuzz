public class MyJVMTest_6239 {

    void testMethod() {
        int sum = 0;
        for (int i = 100000; i >= 0; i--) {
            sum += Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6239().testMethod();
    }
}
