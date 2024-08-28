public class MyJVMTest_5035 {

    static Object object = 0;

    static long field = 0;

    Object methodForCompilation(Object object) {
        int i = object.hashCode();
        i = i * 2000 / 1994 + 153;
        field = i;
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5035().methodForCompilation(object);
    }
}
