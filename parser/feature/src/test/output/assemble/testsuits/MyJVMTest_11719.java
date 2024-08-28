public class MyJVMTest_11719 {

    void pause() {
        try {
            Thread.yield();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11719().pause();
    }
}
