public class MyJVMTest_18198 {

    static I arg = null;

    I m(I arg) {
        throw new RuntimeException("Less-specific method invocation.");
        return arg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18198().m(arg);
    }
}
