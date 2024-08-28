public class MyJVMTest_5620 {

    void checkPoint() {
        new Integer("4");
        return;
    }

    void chain3() {
        checkPoint();
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5620().chain3();
    }
}
