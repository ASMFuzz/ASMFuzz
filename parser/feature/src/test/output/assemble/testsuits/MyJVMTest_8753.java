public class MyJVMTest_8753 {

    static IllegalSignature<?> outer = null;

    IllegalSignature<?> test(IllegalSignature<?> outer) {
        outer.new Inner() {
        };
        return outer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8753().test(outer);
    }
}
