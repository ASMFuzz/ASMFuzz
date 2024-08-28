public class MyJVMTest_451 {

    void emptyDocComment4() {
        System.out.println("minimal javadoc comment");
        System.out.println("- contains nothing");
        System.out.println("- ends on same line as comment start");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_451().emptyDocComment4();
    }
}
