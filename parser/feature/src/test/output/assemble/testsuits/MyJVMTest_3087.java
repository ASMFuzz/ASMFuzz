public class MyJVMTest_3087 {

    void foo() throws Throwable {
        throw (Throwable) null;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3087().foo();
    }
}
