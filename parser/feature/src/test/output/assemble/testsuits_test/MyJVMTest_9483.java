public class MyJVMTest_9483 {

    static int LIMIT = 1_000_000;

    static int counter = 4;

    boolean doSomething() {
        return counter++ < LIMIT;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9483().doSomething());
    }
}
