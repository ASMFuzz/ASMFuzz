public class MyJVMTest_4134 {

    static int mls = 812918880;

    int pause(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mls;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4134().pause(mls);
    }
}
