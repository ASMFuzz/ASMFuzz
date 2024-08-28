public class MyJVMTest_1744 {

    String getString() {
        return "ClassToRedefine01: Class is redefined";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1744().getString());
    }
}
