public class MyJVMTest_7905 {

    static int foo = 1;

    int sampleJavaMethod(int foo) {
        return 100 + foo;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7905().sampleJavaMethod(foo));
    }
}
