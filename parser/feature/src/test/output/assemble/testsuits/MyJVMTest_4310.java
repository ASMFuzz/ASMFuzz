public class MyJVMTest_4310 {

    static Object object = 8;

    static Object field = 0;

    static int field2 = -1;

    Object methodForCompilation(Object object) {
        int i = object.hashCode();
        i = i * 2000 / 1994 + 153;
        field2 = i;
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4310().methodForCompilation(object);
    }
}
