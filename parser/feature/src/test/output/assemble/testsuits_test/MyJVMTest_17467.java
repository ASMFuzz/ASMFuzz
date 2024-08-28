public class MyJVMTest_17467 {

    static int foo = -1686819586;

    int sampleJavaMethod(int foo) {
        return 100 + foo;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17467().sampleJavaMethod(foo));
    }
}
