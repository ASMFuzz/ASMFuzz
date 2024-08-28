public class MyJVMTest_11295 {

    void singleChar2() {
        System.out.println("javadoc comment");
        System.out.println("- contains a single character, no trailing whitespace");
        System.out.println("- ends on new line ");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11295().singleChar2();
    }
}
