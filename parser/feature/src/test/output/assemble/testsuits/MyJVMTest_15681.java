import java.io.*;

public class MyJVMTest_15681 {

    static Object initObj = 0;

    static String SER_METHOD_NAME = "checkSerializable";

    Object checkSerializable(Object initObj) throws Exception {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(initObj);
            out.close();
            byte[] buf = bos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(buf);
            ObjectInputStream in = new ObjectInputStream(bais);
            SerializableObject finObj = (SerializableObject) in.readObject();
            in.close();
            throw new Error();
        } catch (ObjectStreamException ex) {
            StackTraceElement[] stes = ex.getStackTrace();
            boolean found = false;
            for (int i = 0; i < stes.length - 1; i++) {
                StackTraceElement ste = stes[i];
                String nme = ste.getMethodName();
                if (nme.equals(SER_METHOD_NAME)) {
                    found = true;
                }
            }
            if (found) {
                if (ex.getCause() != null) {
                    throw new Error("\nTest for CR 7110700 FAILED");
                }
                System.err.println("\nTEST PASSED");
            } else {
                throw new Error("\nTest for CR 6317435 FAILED");
            }
        }
        return initObj;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15681().checkSerializable(initObj);
    }
}
