public class MyJVMTest_1637 {

    String helpMethodEntryWithStackGrow() {
        return "Test growing the stack during a MethodEntry event on a native method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1637().helpMethodEntryWithStackGrow());
    }
}
