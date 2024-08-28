public class MyJVMTest_10004 {

    void singleChar0() {
        System.out.println("javadoc comment");
        System.out.println("- contains a single character");
        System.out.println("- ends on same line as comment start");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10004().singleChar0();
    }
}
