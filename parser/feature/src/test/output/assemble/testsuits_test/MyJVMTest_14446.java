public class MyJVMTest_14446 {

    static Object object = 6;

    static long field = -8000717322658365253L;

    Object methodForCompilation(Object object) {
        int i = object.hashCode();
        i = i * 2000 / 1994 + 153;
        field = i;
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14446().methodForCompilation(object);
    }
}
