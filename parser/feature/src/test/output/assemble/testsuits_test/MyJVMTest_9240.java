public class MyJVMTest_9240 {

    void method2() {
        System.out.println("Source13#method2() : Performing array copy..");
        double counter = 0;
        for (int i = 5; i < 10; i++) {
            counter += Math.random();
            System.arraycopy(new String[] { "1", "2", "3" }, 0, new Object[] { "4", "5", "6" }, 1, 2);
        }
        System.out.println("Done!");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9240().method2();
    }
}
