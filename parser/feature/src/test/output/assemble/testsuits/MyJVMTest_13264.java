public class MyJVMTest_13264 {

    void emptyDocComment0() {
        System.out.println("javadoc comment");
        System.out.println("- contains whitespace");
        System.out.println("- ends on same line as potential comment");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13264().emptyDocComment0();
    }
}
