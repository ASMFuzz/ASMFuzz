public class MyJVMTest_4067 {

    String helpMethodExitFromNative() {
        return "Test firing of the MethodExitNoRc event on an exit from a Native method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4067().helpMethodExitFromNative());
    }
}
