import java.lang.reflect.Array;
import java.util.Arrays;

public class MyJVMTest_2061 {

    static Object[] a = { 0, 5, 5, -281366632, 1946957189, -664167006, 9, 4, 0, -251606132 };

    void toArray0(Object[] a) throws Exception {
        // MutationbyInsert The Seed of:	/root/asmfuzz/seedData/pass_data/0/MyJVMTest_2061.java
        byte[] buf = { 58, -29, 13, 102, 11, -82, 112, -79, 107, 76 };
        if (buf == null)
            buf = new byte[8192];
        if (fLength > 0) {
            System.arraycopy(fArray, 0, a, 0, fLength);
        }
    }

    // The array to hold all data
    static Object[] fArray = { 4, 2, 0, 0, -2086503795, 6, -114453699, 1644926886, 4, 1 };

    // Number of elements in this list
    static int fLength = 379041368;

    Object[] toArray(Object[] a) throws Exception {
        if (a.length < fLength) {
            Class arrayClass = a.getClass();
            Class componentType = arrayClass.getComponentType();
            a = (Object[]) Array.newInstance(componentType, fLength);
        }
        toArray0(a);
        if (a.length > fLength) {
            a[fLength] = null;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2061().toArray(a)));
    }
}
