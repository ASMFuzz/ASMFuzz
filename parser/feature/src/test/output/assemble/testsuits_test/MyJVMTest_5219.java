public class MyJVMTest_5219 {

    static int i = 1;

    static boolean crash = false;

    A m2() {
        if (crash) {
            return null;
        }
        return new A();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5219().m2());
    }
}
