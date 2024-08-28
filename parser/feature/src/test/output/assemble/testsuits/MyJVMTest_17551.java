import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_17551 {

    static String newValue = "!m[Cf[gGYS";

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "ECF\"KS?^l[";

    String setValue(String newValue) {
        mxBean.setVMOption(name, newValue);
        return newValue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17551().setValue(newValue);
    }
}
