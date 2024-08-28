public class MyJVMTest_10859 {

    String helpMethodEntryWithStackGrow() {
        return "Test growing the stack during a MethodEntry event on a native method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10859().helpMethodEntryWithStackGrow());
    }
}
