import java.util.prefs.*;

public class MyJVMTest_10566 {

    static AbstractPreferences evtParam1Param1 = null;

    static String evtParam1Param2 = "m=gT!~UFMu";

    static Preferences evtParam1 = new AbstractPreferences(evtParam1Param1, evtParam1Param2);

    static AbstractPreferences evtParam2Param1 = null;

    static String evtParam2Param2 = "7$N_?oBue.";

    static Preferences evtParam2 = new AbstractPreferences(evtParam2Param1, evtParam2Param2);

    static NodeChangeEvent evt = new NodeChangeEvent(evtParam1, evtParam2);

    static int totalNode = 0;

    NodeChangeEvent childRemoved(NodeChangeEvent evt) {
        totalNode--;
        return evt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10566().childRemoved(evt);
    }
}
