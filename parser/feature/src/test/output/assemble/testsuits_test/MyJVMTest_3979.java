import java.io.*;

public class MyJVMTest_3979 {

    static byte[] inParam1Param1 = { 58, -15, 109, 97, -52, -49, -98, -105, -78, -86 };

    static int inParam1Param2 = 424;

    static int inParam1Param3 = 143;

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1, inParam1Param2, inParam1Param3);

    static ObjectInputStream in = new ObjectInputStream(inParam1);

    static boolean z = false;

    static byte b = 0;

    static char c = '0';

    static short s = -13074;

    static int i = 2;

    static long j = -9223372036854775808L;

    static float f = Float.NEGATIVE_INFINITY;

    static double d = Double.NEGATIVE_INFINITY;

    static String str = "ECcd1J;\"0|";

    ObjectInputStream.GetField readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        if ((fields.get("z", false) != true) || (fields.get("b", (byte) 0) != 5) || (fields.get("c", '0') != '5') || (fields.get("s", (short) 0) != 5) || (fields.get("i", 0) != 5) || (fields.get("j", 0l) != 5) || (fields.get("f", 0.0f) != 5.0f) || (fields.get("d", 0.0) != 5.0) || (!fields.get("str", null).equals("5"))) {
            throw new Error();
        }
        return fields;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3979().readObject(in);
    }
}
