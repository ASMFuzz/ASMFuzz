import com.sun.management.HotSpotDiagnosticMXBean;

public class MyJVMTest_6649 {

    static String value = "%I38*=1K@5";

    String getValue() {
        return mxBean.getVMOption(name).getValue();
    }

    void setValue(String newValue) {
        mxBean.setVMOption(name, newValue);
    }

    static HotSpotDiagnosticMXBean mxBean = null;

    static String name = ">d7vs|QCn-";

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
        System.out.println(new MyJVMTest_6649().isValidValue(value));
    }
}
