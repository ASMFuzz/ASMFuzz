import java.lang.reflect.Constructor;

public class MyJVMTest_9623 {

    static byte[] H = { 121, 37, 24, 37, -99, 55, 43, -114, -77, 53 };

    static Constructor<?> GHASH = null;

    static Method UPDATE = null;

    static Method DIGEST = null;

    Object newGHASH(byte[] H) throws Exception {
        return GHASH.newInstance(H);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9623().newGHASH(H));
    }
}
