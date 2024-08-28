public class MyJVMTest_708 {

    void emptyDocComment6() {
        System.out.println("javadoc comment");
        System.out.println("- contains \"*\"");
        System.out.println("- ends on same line as comment start");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_708().emptyDocComment6();
    }
}
