public class MyJVMTest_6096 {

    static T object = null;

    T run(T object) {
        throw new Error("method is overridden");
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6096().run(object);
    }
}
