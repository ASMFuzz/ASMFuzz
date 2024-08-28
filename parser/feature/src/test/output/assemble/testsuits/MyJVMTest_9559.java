import java.util.Arrays;

public class MyJVMTest_9559 {

    static long[] array = { 9223372036854775807L, -8045911462540177465L, -4358951412738789587L, 0, 9223372036854775807L, -2566540218476962301L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0 };

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
        System.out.println(Arrays.asList(new MyJVMTest_9559().reset(array)));
    }
}
