public class MyJVMTest_12025 {

    void overflow() {
        count += 1;
        overflow();
    }

    static int count = 2;

    void printIt() {
        System.out.println("Going to overflow stack");
        try {
            new DoOverflow().overflow();
        } catch (java.lang.StackOverflowError e) {
            System.out.println("Overflow OK " + count);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12025().printIt();
    }
}
