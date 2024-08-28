public class MyJVMTest_12398 {

    void foo() throws Throwable {
        throw (Throwable) null;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12398().foo();
    }
}
