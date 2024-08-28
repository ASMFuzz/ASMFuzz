public class MyJVMTest_9448 {

    void overflow() {
        count += 1;
        overflow();
    }

    static int count = 357437068;

    void printIt() {
        System.out.println("Going to overflow stack");
        try {
            new DoOverflow().overflow();
        } catch (java.lang.StackOverflowError e) {
            System.out.println("Test PASSED. Got StackOverflowError at " + count + " iteration");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9448().printIt();
    }
}
