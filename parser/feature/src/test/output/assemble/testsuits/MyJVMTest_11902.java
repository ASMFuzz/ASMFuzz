public class MyJVMTest_11902 {

    void checkPoint() {
        Integer.valueOf("4");
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11902().checkPoint();
    }
}
