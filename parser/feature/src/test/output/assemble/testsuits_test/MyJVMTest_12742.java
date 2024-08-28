public class MyJVMTest_12742 {

    static Object[] testArray = new Object[4];

    static boolean keepRunning = true;

    void run() {
        while (keepRunning) {
            String name = testArray[2].getClass().getName();
            if (!(name.endsWith("String"))) {
                throw new RuntimeException("got wrong class name");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12742().run();
    }
}
