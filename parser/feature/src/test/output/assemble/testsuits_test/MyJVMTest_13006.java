public class MyJVMTest_13006 {

    void emptyDocComment3() {
        System.out.println("javadoc comment");
        System.out.println("- contains whitespace");
        System.out.println("- ends on new line ");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13006().emptyDocComment3();
    }
}
