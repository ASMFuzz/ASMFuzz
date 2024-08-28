public class MyJVMTest_8431 {

    static T8203436a<?> outer = null;

    T8203436a<?> test(T8203436a<?> outer) {
        outer.new Inner() {
        };
        return outer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8431().test(outer);
    }
}
