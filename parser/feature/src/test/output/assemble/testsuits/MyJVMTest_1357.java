import java.util.prefs.*;

public class MyJVMTest_1357 {

    static AbstractPreferences evtParam1Param1 = null;

    static String evtParam1Param2 = "jhj7s[rc}4";

    static Preferences evtParam1 = new AbstractPreferences(evtParam1Param1, evtParam1Param2);

    static AbstractPreferences evtParam2Param1 = null;

    static String evtParam2Param2 = "o'-S>\\rbyl";

    static Preferences evtParam2 = new AbstractPreferences(evtParam2Param1, evtParam2Param2);

    static NodeChangeEvent evt = new NodeChangeEvent(evtParam1, evtParam2);

    static int totalNode = 0;

    NodeChangeEvent childRemoved(NodeChangeEvent evt) {
        totalNode--;
        return evt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1357().childRemoved(evt);
    }
}
