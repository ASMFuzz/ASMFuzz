public class MyJVMTest_11376 {

    static S s = null;

    static T t = null;

    static int size = 0;

    <S extends Readable & AutoCloseable, T extends Appendable & AutoCloseable> T copy(S s, T t, int size) throws Exception {
        try (S src = s;
            T trg = t) {
        }
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11376().copy(s, t, size);
    }
}
