import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_11227 {

    String getValue() {
        return mxBean.getVMOption(name).getValue();
    }

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "RaqMbUK=La";

    String getString(String name) {
        return new DynamicVMOption(name).getValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11227().getString(name));
    }
}
