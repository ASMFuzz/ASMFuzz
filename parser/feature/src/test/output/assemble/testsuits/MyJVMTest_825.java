public class MyJVMTest_825 {

    void singleChar0() {
        System.out.println("javadoc comment");
        System.out.println("- contains a single character");
        System.out.println("- ends on same line as comment start");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_825().singleChar0();
    }
}
