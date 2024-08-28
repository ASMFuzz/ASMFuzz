public class MyJVMTest_4009 {

    void emptyDocComment1() {
        System.out.println("javadoc comment");
        System.out.println("- contains nothing");
        System.out.println("- ends on same line as potential comment");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4009().emptyDocComment1();
    }
}
