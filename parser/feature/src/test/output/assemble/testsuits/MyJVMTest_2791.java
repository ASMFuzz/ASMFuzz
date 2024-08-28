public class MyJVMTest_2791 {

    static int errorCount = 0;

    static ClassLoader parent = null;

    void incrError() {
        ++errorCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2791().incrError();
    }
}
