public class MyJVMTest_15056 {

    void checkPoint() {
        new Integer("4");
        return;
    }

    void chain3() {
        checkPoint();
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15056().chain3();
    }
}
