public class MyJVMTest_827 {

    static int n = 0;

    int testedInstanceMethod(int n) {
        return n * 3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_827().testedInstanceMethod(n));
    }
}
