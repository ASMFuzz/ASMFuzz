public class MyJVMTest_5010 {

    String getString() {
        return "ClassToRedefine02: Class is redefined";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5010().getString());
    }
}
