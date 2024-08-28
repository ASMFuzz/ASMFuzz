public class MyJVMTest_11672 {

    String helpMethodExitFromJava() {
        return "Test firing of the MethodExitNoRc event on an exit from a Java method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11672().helpMethodExitFromJava());
    }
}
