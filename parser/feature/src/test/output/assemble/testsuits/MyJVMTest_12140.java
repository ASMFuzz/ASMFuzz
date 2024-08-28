import java.util.Arrays;

public class MyJVMTest_12140 {

    static U[] a = { null, null, null, null, null, null, null, null, null, null };

    <T, U extends T> T[] cast(U[] a) {
        return (T[]) a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12140().cast(a)));
    }
}
