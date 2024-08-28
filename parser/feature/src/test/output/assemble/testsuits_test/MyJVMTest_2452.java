public class MyJVMTest_2452 {

    void pause() {
        try {
            Thread.yield();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2452().pause();
    }
}
