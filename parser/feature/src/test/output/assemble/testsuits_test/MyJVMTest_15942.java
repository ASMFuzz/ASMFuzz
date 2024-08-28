public class MyJVMTest_15942 {

    Object getA() {
        return a;
    }

    static A a = null;

    int test() {
        Object a = getA();
        if (a instanceof B) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15942().test());
    }
}
