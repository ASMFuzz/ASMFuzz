public class MyJVMTest_15557 {

    static T object = null;

    T run(T object) {
        throw new Error("method is overridden");
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15557().run(object);
    }
}
