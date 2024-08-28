public class MyJVMTest_9884 {

    void emptyDocComment6() {
        System.out.println("javadoc comment");
        System.out.println("- contains \"*\"");
        System.out.println("- ends on same line as comment start");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9884().emptyDocComment6();
    }
}
