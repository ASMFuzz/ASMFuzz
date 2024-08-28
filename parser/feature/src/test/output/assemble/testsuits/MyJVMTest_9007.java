public class MyJVMTest_9007 {

    static int errorCount = 0;

    void incrError() {
        ++errorCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9007().incrError();
    }
}
