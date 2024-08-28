public class MyJVMTest_2621 {

    void checkPoint() {
        Integer.valueOf("4");
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2621().checkPoint();
    }
}
