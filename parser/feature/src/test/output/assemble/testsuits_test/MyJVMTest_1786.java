public class MyJVMTest_1786 {

    static int errorCount = 0;

    void incrError() {
        ++errorCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1786().incrError();
    }
}
