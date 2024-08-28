public class MyJVMTest_16364 {

    String testMethod() {
        return "foo";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16364().testMethod());
    }
}
