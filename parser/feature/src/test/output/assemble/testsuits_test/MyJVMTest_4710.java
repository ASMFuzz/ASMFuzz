public class MyJVMTest_4710 {

    static int millis = 9;

    int delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
        return millis;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4710().delay(millis);
    }
}
