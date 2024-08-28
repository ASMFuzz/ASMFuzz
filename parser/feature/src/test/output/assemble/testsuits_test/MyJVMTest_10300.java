public class MyJVMTest_10300 {

    A create() {
        return new A();
    }

    static Object f = 5;

    Object get() {
        if (f == null) {
            f = create();
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10300().get());
    }
}
