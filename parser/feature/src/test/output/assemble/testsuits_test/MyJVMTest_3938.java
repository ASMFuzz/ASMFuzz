import javax.management.*;
import javax.management.modelmbean.*;

public class MyJVMTest_3938 {

    static String opName = ":w.DA\\4&zi";

    static Object[] opArgs = { 1815597596, 2, 2094122171, -2075361785, 2, -991272790, 6, 3, 0, 0 };

    static String[] sig = { "Xzs?BgbOVj", "1L.sqt6D$g", "LA|-'5&)d8", "gjKEA*otrN", "$DN@*4UXT\\", "w,K,f,2E%^", ",mgW<HZY$.", "M3\\>ozz*ay", "'v-HgXc57&", "qr*S<wVU)0" };

    static boolean noddyCalled = false;

    static ModelMBeanInfo mmbInfo = null;

    Object invoke(String opName, Object[] opArgs, String[] sig) throws MBeanException, ReflectionException {
        if (opName.equals("noddy")) {
            noddyCalled = true;
            return null;
        } else
            throw new IllegalArgumentException("Not noddy: " + opName);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3938().invoke(opName, opArgs, sig));
    }
}
