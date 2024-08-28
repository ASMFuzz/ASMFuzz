public class MyJVMTest_4029 {

    B foo() {
        return new B();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4029().foo());
    }
}
