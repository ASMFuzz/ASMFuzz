import java.util.Arrays;

public class MyJVMTest_2844 {

    static U[] a = { null, null, null, null, null, null, null, null, null, null };

    <T, U extends T> T[] cast(U[] a) {
        return (T[]) a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2844().cast(a)));
    }
}
