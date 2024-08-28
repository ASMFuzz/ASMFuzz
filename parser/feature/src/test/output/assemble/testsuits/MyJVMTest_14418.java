public class MyJVMTest_14418 {

    String getString() {
        return "ClassToRedefine02: Class is redefined";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14418().getString());
    }
}
