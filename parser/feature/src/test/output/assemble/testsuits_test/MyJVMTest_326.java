public class MyJVMTest_326 {

    static int LIMIT = 1_000_000;

    static int counter = -114342722;

    boolean doSomething() {
        return counter++ < LIMIT;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_326().doSomething());
    }
}
