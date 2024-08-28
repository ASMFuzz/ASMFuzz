public class MyJVMTest_10193 {

    void run() {
        System.out.println("shutdown hook called");
        long elapsedTime = System.currentTimeMillis() - RMIExitTest.exitStartTime;
        if (elapsedTime >= 5000) {
            System.out.println("BUG 4917237 not Fixed.");
            Runtime.getRuntime().halt(1);
        } else {
            System.out.println("BUG 4917237 Fixed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10193().run();
    }
}
