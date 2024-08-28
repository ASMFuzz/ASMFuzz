public class MyJVMTest_3918 {

    void emptyDocComment0() {
        System.out.println("javadoc comment");
        System.out.println("- contains whitespace");
        System.out.println("- ends on same line as potential comment");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3918().emptyDocComment0();
    }
}
