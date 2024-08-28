public class MyJVMTest_13362 {

    void emptyDocComment1() {
        System.out.println("javadoc comment");
        System.out.println("- contains nothing");
        System.out.println("- ends on same line as potential comment");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13362().emptyDocComment1();
    }
}
