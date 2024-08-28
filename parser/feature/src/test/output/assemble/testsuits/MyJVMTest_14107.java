public class MyJVMTest_14107 {

    static int millis = 0;

    int delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
        return millis;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14107().delay(millis);
    }
}
