import javax.swing.UIManager;

public class MyJVMTest_9244 {

    static String[] properties = { "\"=1I|gT'gy", "`pi0}^cf6\"", "\\XkB/DSZS)", "+_bEmC@T\\p", "pzRbp|g|{)", "9LcM5PV>lA", "a{b>s;lr#b", "H,qKQ>AaZp", "DMk85+=I07", "Nhe/$:jlto" };

    String test(final String[] properties) {
        for (final String name : properties) {
            String value = UIManager.getString(name);
            if (value == null) {
                System.err.println("Current LookAndFeel = " + UIManager.getLookAndFeel().getDescription());
                System.err.printf("The value for %s property is null\n", name);
                throw new Error();
            }
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9244().test(properties);
    }
}
