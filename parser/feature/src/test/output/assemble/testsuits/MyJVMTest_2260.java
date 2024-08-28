public class MyJVMTest_2260 {

    void checkPoint() {
        new Integer("4");
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2260().checkPoint();
    }
}
