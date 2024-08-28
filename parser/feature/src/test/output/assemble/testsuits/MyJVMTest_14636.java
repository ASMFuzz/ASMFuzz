public class MyJVMTest_14636 {

    static int i = 0;

    static boolean crash = false;

    A m2() {
        if (crash) {
            return null;
        }
        return new A();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14636().m2());
    }
}
