import java.io.*;

public class MyJVMTest_13329 {

    static ObjectInputStream in = new ObjectInputStream();

    static boolean z = false;

    static byte b = 0;

    static char c = '0';

    static short s = -32768;

    static int i = -377645374;

    static long j = -2931579802739324718L;

    static float f = Float.NEGATIVE_INFINITY;

    static double d = 0.23145697770363094;

    static String str = "pE2z'}^H6,";

    ObjectInputStream.GetField readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        if ((fields.get("z", false) != true) || (fields.get("b", (byte) 0) != 5) || (fields.get("c", '0') != '5') || (fields.get("s", (short) 0) != 5) || (fields.get("i", 0) != 5) || (fields.get("j", 0l) != 5) || (fields.get("f", 0.0f) != 5.0f) || (fields.get("d", 0.0) != 5.0) || (!fields.get("str", null).equals("5"))) {
            throw new Error();
        }
        return fields;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13329().readObject(in);
    }
}
