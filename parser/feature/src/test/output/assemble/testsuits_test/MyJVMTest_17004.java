public class MyJVMTest_17004 {

    void singleChar3() {
        System.out.println("javadoc comment");
        System.out.println("- contains a single character and trailing whitespace");
        System.out.println("- ends on new line ");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17004().singleChar3();
    }
}
