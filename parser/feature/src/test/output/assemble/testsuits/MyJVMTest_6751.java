public class MyJVMTest_6751 {

    void breakpoint1() {
    }

    void callWait() {
        try {
            this.wait(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        breakpoint1();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6751().callWait();
    }
}
