public class MyJVMTest_11010 {

    static int errorCount = 0;

    void incrError() {
        ++errorCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11010().incrError();
    }
}
