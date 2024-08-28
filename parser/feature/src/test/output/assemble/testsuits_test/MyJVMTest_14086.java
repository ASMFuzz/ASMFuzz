public class MyJVMTest_14086 {

    static Object object = 0;

    static int field2 = -1;

    Object methodForCompilation(Object object) {
        int i = object.hashCode();
        i = i * 2000 / 1994 + 153;
        field2 = i;
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14086().methodForCompilation(object);
    }
}
