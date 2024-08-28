public class MyJVMTest_3210 {

    void emptyDocComment2() {
        System.out.println("javadoc comment");
        System.out.println("- contains whitespace");
        System.out.println("- ends on same line as comment start");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3210().emptyDocComment2();
    }
}
