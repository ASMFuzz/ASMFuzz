public class MyJVMTest_9408 {

    void singleChar1() {
        System.out.println("javadoc comment");
        System.out.println("- contains a single character and trailing whitespace");
        System.out.println("- ends on same line as potential comment");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9408().singleChar1();
    }
}
