public class MyJVMTest_1105 {

    A create() {
        return new A();
    }

    static Object f = 0;

    Object get() {
        if (f == null) {
            f = create();
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1105().get());
    }
}
