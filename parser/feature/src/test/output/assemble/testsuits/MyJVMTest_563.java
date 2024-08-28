import java.security.*;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.util.Arrays;

public class MyJVMTest_563 {

    static ClassLoader loader = null;

    static String className = "Rta0d|K5!O";

    static Class<?> classBeingRedefined = null;

    static String protectionDomainParam1Param1Param1 = "<WUwqF.O=*";

    static String protectionDomainParam1Param1Param2 = "FN156~<\"]-";

    static int protectionDomainParam1Param1Param3 = 53;

    static String protectionDomainParam1Param1Param4 = "!M|;.:tD$#";

    static URLStreamHandler protectionDomainParam1Param1Param5 = null;

    static URL protectionDomainParam1Param1 = new URL(protectionDomainParam1Param1Param1, protectionDomainParam1Param1Param2, protectionDomainParam1Param1Param3, protectionDomainParam1Param1Param4, protectionDomainParam1Param1Param5);

    static Certificate[] protectionDomainParam1Param2 = { null, null, null, null, null, null, null, null, null, null };

    static CodeSource protectionDomainParam1 = new CodeSource(protectionDomainParam1Param1, protectionDomainParam1Param2);

    static PermissionCollection protectionDomainParam2 = null;

    static ProtectionDomain protectionDomain = new ProtectionDomain(protectionDomainParam1, protectionDomainParam2);

    static byte[] classfileBuffer = { -93, 75, 67, 63, -127, -7, -33, -38, 114, 26 };

    byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        byte[] newBuffer = new byte[classfileBuffer.length];
        System.arraycopy(classfileBuffer, 0, newBuffer, 0, classfileBuffer.length);
        return newBuffer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_563().transform(loader, className, classBeingRedefined, protectionDomain, classfileBuffer)));
    }
}
