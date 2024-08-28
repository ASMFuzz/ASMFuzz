import java.io.*;

public class MyJVMTest_508 {

    static int major = 0;

    static int minor = 0;

    static boolean expectSupported = true;

    static ClassLoader cl = null;

    boolean checkClassVersion(int major, int minor, boolean expectSupported) throws Exception {
        final String className = "ClassVersionTest";
        final String classFile = className + ".class";
        final DataOutputStream dos = new DataOutputStream(new FileOutputStream(classFile));
        dos.writeLong((0xCafeBabel << 32) + (minor << 16) + major);
        dos.close();
        boolean supported = true;
        try {
            Class.forName(className, false, cl);
        } catch (UnsupportedClassVersionError e) {
            supported = false;
        } catch (Throwable t) {
        }
        new File(classFile).delete();
        if (supported != expectSupported)
            throw new Exception("Forgot to update java.class.version?");
        return supported;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_508().checkClassVersion(major, minor, expectSupported);
    }
}
