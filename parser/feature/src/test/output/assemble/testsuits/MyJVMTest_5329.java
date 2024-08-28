import static java.lang.Thread.holdsLock;

public class MyJVMTest_5329 {

    void test() {
        holdsLock(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5329().test();
    }
}
