public class MyJVMTest_3649 {

    static InterfaceWithDefaultMethod1 x = null;

    int test(InterfaceWithDefaultMethod1 x) {
        return x.defaultMethod();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3649().test(x));
    }
}
