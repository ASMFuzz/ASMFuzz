import java.lang.ref.SoftReference;
import java.lang.reflect.Field;

public class MyJVMTest_14838 {

    static SoftReference r1 = null;

    static SoftReference r2 = null;

    void test() throws Throwable {
        Field age = SoftReference.class.getDeclaredField("age");
        age.setAccessible(true);
        r1.get();
        r2.get();
        int prevAge = -1;
        for (int i = 0; i < 70; i++) {
            int age1 = age.getInt(r1);
            int age2 = age.getInt(r2);
            if (age1 != age2) {
                throw new Error("SoftReference1.age (" + age1 + ") not equal to SoftReference2.age (" + age2 + ")");
            } else if (age1 <= prevAge) {
                throw new Error("SoftReference age failed to increase following System.gc()");
            }
            System.gc();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14838().test();
    }
}
