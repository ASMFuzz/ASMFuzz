import java.util.Arrays;

public class MyJVMTest_402 {

    static long[] array = { -4260045324891265326L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -6511300323053796639L, -917097481278629458L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    long[] reset(long[] array) {
        if (null == array) {
            array = new long[3];
        }
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_402().reset(array)));
    }
}
