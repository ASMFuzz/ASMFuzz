public class MyJVMTest_13495 {

    static int mls = 0;

    int pause(int mls) {
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mls;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13495().pause(mls);
    }
}
