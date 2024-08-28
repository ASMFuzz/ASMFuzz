public class MyJVMTest_2128 {

    static S s = null;

    static T t = null;

    static int size = -208806096;

    <S extends Readable & AutoCloseable, T extends Appendable & AutoCloseable> T copy(S s, T t, int size) throws Exception {
        try (S src = s;
            T trg = t) {
        }
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2128().copy(s, t, size);
    }
}
