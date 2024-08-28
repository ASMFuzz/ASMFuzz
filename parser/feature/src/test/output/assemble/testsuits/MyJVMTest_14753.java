import static java.lang.Thread.holdsLock;

public class MyJVMTest_14753 {

    void test() {
        holdsLock(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14753().test();
    }
}
