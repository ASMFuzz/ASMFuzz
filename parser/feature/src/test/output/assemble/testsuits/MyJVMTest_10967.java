public class MyJVMTest_10967 {

    String getString() {
        return "ClassToRedefine01: Class is redefined";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10967().getString());
    }
}
