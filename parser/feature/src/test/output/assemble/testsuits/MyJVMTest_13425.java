public class MyJVMTest_13425 {

    String helpMethodExitFromNative() {
        return "Test firing of the MethodExitNoRc event on an exit from a Native method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13425().helpMethodExitFromNative());
    }
}
