public class MyJVMTest_10006 {

    static int n = 9;

    int testedInstanceMethod(int n) {
        return n * 3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10006().testedInstanceMethod(n));
    }
}
