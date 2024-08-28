public class MyJVMTest_13382 {

    B foo() {
        return new B();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13382().foo());
    }
}
