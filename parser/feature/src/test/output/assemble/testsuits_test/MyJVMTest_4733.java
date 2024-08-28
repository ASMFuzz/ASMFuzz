import java.util.prefs.*;

public class MyJVMTest_4733 {

    static AbstractPreferences evtParam1Param1 = null;

    static String evtParam1Param2 = "=aSPS3=X@@";

    static Preferences evtParam1 = new AbstractPreferences(evtParam1Param1, evtParam1Param2);

    static AbstractPreferences evtParam2Param1 = null;

    static String evtParam2Param2 = "R|O7#P9 }~";

    static Preferences evtParam2 = new AbstractPreferences(evtParam2Param1, evtParam2Param2);

    static NodeChangeEvent evt = new NodeChangeEvent(evtParam1, evtParam2);

    static int totalNode = 0;

    NodeChangeEvent childAdded(NodeChangeEvent evt) {
        totalNode++;
        return evt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4733().childAdded(evt);
    }
}
