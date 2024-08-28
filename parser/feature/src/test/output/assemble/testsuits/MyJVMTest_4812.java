public class MyJVMTest_4812 {

    void bugReportExample() {
        {
        }
        Object x = (Object) 1;
        int y = (int) x;
        {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4812().bugReportExample();
    }
}
