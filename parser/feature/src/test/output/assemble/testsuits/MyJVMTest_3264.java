public class MyJVMTest_3264 {

    void emptyDocComment5() {
        System.out.println("minimal _java_ comment");
        System.out.println("- contains nothing");
        System.out.println("- ends on same line as comment start");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3264().emptyDocComment5();
    }
}
