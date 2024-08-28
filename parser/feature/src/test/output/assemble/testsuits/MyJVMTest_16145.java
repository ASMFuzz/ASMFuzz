import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_16145 {

    static String value = "E#>[jLFMXA";

    String getValue() {
        return mxBean.getVMOption(name).getValue();
    }

    void setValue(String newValue) {
        mxBean.setVMOption(name, newValue);
    }

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = "aq]qzy\"*QG";

    boolean isValidValue(String value) {
        boolean isValid = true;
        String oldValue = getValue();
        try {
            setValue(value);
        } catch (NullPointerException e) {
            if (value == null) {
                isValid = false;
            }
        } catch (IllegalArgumentException e) {
            isValid = false;
        } finally {
            setValue(oldValue);
        }
        return isValid;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16145().isValidValue(value));
    }
}
