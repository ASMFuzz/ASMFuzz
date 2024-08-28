import javax.naming.*;

public class MyJVMTest_15192 {

    static Name name = null;

    static String[] comps = { "JqJUg%<=M1", "|*2R+C~/8T", "%6qNI7bOt;", "C>zY.A/W0J", "LyA?be ek?", "yy#5bt_?_E", "X26\\c@0DPR", "!6Glldq+tz", "o\\#O.;m\"Uh", "s4K8LnWfma" };

    Name checkName(Name name, String[] comps) throws Exception {
        if (name.size() != comps.length) {
            throw new Exception("test failed; incorrect component count in " + name + "; " + "expecting " + comps.length + " got " + name.size());
        }
        for (int i = 0; i < name.size(); i++) {
            if (!comps[i].equals(name.get(i))) {
                throw new Exception("test failed; invalid component in " + name + "; " + "expecting '" + comps[i] + "' got '" + name.get(i) + "'");
            }
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15192().checkName(name, comps);
    }
}
