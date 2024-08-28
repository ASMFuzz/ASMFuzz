import java.lang.reflect.Constructor;

public class MyJVMTest_463 {

    static byte[] H = { -33, -83, 38, -115, 19, -75, 0, -47, 98, 61 };

    static Constructor<?> GHASH = null;

    static Method UPDATE = null;

    static Method DIGEST = null;

    Object newGHASH(byte[] H) throws Exception {
        return GHASH.newInstance(H);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_463().newGHASH(H));
    }
}
