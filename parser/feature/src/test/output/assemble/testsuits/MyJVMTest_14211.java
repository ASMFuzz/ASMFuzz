public class MyJVMTest_14211 {

    void bugReportExample() {
        {
        }
        Object x = (Object) 1;
        int y = (int) x;
        {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14211().bugReportExample();
    }
}
