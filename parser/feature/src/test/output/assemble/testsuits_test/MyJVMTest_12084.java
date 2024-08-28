public class MyJVMTest_12084 {

    static int errorCount = 0;

    static ClassLoader parent = null;

    void incrError() {
        ++errorCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12084().incrError();
    }
}
