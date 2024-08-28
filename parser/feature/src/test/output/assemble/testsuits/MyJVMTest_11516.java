public class MyJVMTest_11516 {

    void checkPoint() {
        new Integer("4");
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11516().checkPoint();
    }
}
