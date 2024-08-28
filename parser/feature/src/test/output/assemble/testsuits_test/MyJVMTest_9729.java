import java.security.*;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.util.Arrays;

public class MyJVMTest_9729 {

    static ClassLoader loader = null;

    static String className = ".-be8$`wt9";

    static Class<?> classBeingRedefined = null;

    static String protectionDomainParam1Param1Param1 = "Zl\"na\\qm^U";

    static String protectionDomainParam1Param1Param2 = "4~05AEk4qp";

    static int protectionDomainParam1Param1Param3 = 777;

    static String protectionDomainParam1Param1Param4 = "ta{%zB(!kQ";

    static URL protectionDomainParam1Param1 = new URL(protectionDomainParam1Param1Param1, protectionDomainParam1Param1Param2, protectionDomainParam1Param1Param3, protectionDomainParam1Param1Param4);

    static CodeSigner[] protectionDomainParam1Param2 = { null, null, null, null, null, null, null, null, null, null };

    static CodeSource protectionDomainParam1 = new CodeSource(protectionDomainParam1Param1, protectionDomainParam1Param2);

    static PermissionCollection protectionDomainParam2 = null;

    static ClassLoader protectionDomainParam3 = null;

    static Principal[] protectionDomainParam4 = { null, null, null, null, null, null, null, null, null, null };

    static ProtectionDomain protectionDomain = new ProtectionDomain(protectionDomainParam1, protectionDomainParam2, protectionDomainParam3, protectionDomainParam4);

    static byte[] classfileBuffer = { -14, 43, 11, -125, 5, -12, -4, -116, 126, 8 };

    byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        byte[] newBuffer = new byte[classfileBuffer.length];
        System.arraycopy(classfileBuffer, 0, newBuffer, 0, classfileBuffer.length);
        return newBuffer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9729().transform(loader, className, classBeingRedefined, protectionDomain, classfileBuffer)));
    }
}
