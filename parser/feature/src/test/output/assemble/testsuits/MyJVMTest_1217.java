import java.io.*;
import java.net.URI;

public class MyJVMTest_1217 {

    static String rafParam1Param1Param1Param1Param1 = "Ok:,~B<'I0";

    static String rafParam1Param1Param1Param1Param2 = "\\uks@:_b{>";

    static String rafParam1Param1Param1Param1Param3 = "sk(79Y^DO|";

    static String rafParam1Param1Param1Param1Param4 = "GCX?YRFrh\\";

    static URI rafParam1Param1Param1Param1 = new URI(rafParam1Param1Param1Param1Param1, rafParam1Param1Param1Param1Param2, rafParam1Param1Param1Param1Param3, rafParam1Param1Param1Param1Param4);

    static File rafParam1Param1Param1 = new File(rafParam1Param1Param1Param1);

    static String rafParam1Param1Param2 = ")0=##FBcXr";

    static File rafParam1Param1 = new File(rafParam1Param1Param1, rafParam1Param1Param2);

    static String rafParam1Param2 = "|Dly,{O1>b";

    static File rafParam1 = new File(rafParam1Param1, rafParam1Param2);

    static String rafParam2 = "XGm]I%yItK";

    static RandomAccessFile raf = new RandomAccessFile(rafParam1, rafParam2);

    static int start = 1125325231;

    static int num_to_skip = 0;

    RandomAccessFile doTest(RandomAccessFile raf, int start, int num_to_skip) throws Exception {
        raf.seek(start);
        long cur_ptr = raf.getFilePointer();
        int length = (int) raf.length();
        System.err.println("\nCurrent pointer = " + cur_ptr + " length = " + length + " num_to_skip = " + num_to_skip);
        int num_skipped = raf.skipBytes(num_to_skip);
        System.err.println("After skipBytes -- no. skipped = " + num_skipped);
        if (num_to_skip <= 0) {
            if (num_skipped != 0) {
                System.err.println("Negative Skip Test Failed");
                throw new RuntimeException("Negative Skip Test Failed");
            } else {
                System.err.println("Negative Skip Test Succeeded");
            }
        }
        cur_ptr = raf.getFilePointer();
        System.err.println("Current pointer = " + cur_ptr);
        if (cur_ptr > length) {
            System.err.println("Past EOF Skip Test Failed");
            throw new RuntimeException("Past EOF Skip Test Failed");
        } else {
            System.err.println("Past EOF Skip Test Succeeded");
        }
        int byte_read = raf.read();
        if ((cur_ptr == length) && (byte_read != -1)) {
            System.err.println("byte_read = " + byte_read + " Read Test Failed ......");
            throw new RuntimeException("Read Test Failed");
        } else {
            System.err.println("byte_read = " + byte_read + " Read Test Succeeded");
        }
        return raf;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1217().doTest(raf, start, num_to_skip);
    }
}
