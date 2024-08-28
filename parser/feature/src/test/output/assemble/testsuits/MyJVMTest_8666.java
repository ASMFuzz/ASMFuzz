public class MyJVMTest_8666 {

    void checkPoint() {
        Integer.valueOf("4");
        return;
    }

    void chain3() {
        checkPoint();
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8666().chain3();
    }
}
