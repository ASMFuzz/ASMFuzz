import java.util.prefs.Preferences;

public class MyJVMTest_10134 {

    static boolean failed = false;

    void checkPreferencesRemove() {
        try {
            Preferences node = Preferences.userRoot().node("N1");
            node.remove(null);
            failed = true;
        } catch (NullPointerException npe) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10134().checkPreferencesRemove();
    }
}
