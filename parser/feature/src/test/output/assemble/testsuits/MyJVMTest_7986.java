import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_7986 {

    static String newValue = "<A|GE'j)3[";

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "4!wxKRx()u";

    String setValue(String newValue) {
        mxBean.setVMOption(name, newValue);
        return newValue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7986().setValue(newValue);
    }
}
