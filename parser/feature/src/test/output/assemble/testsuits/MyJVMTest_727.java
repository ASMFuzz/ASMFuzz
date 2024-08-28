public class MyJVMTest_727 {

    boolean work() {
        Thread.yield();
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_727().work());
    }
}
