public class MyJVMTest_9611 {

    void emptyDocComment4() {
        System.out.println("minimal javadoc comment");
        System.out.println("- contains nothing");
        System.out.println("- ends on same line as comment start");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9611().emptyDocComment4();
    }
}
