import javax.naming.*;

public class MyJVMTest_5749 {

    static Name name = null;

    static String[] comps = { "?E'4cf3Rgb", ">D(l/6E0;I", "YLQAR7=s3n", "*pb]J[DI]{", "PTQ?r87S2%", "{G0Uq gUX(", "Ub4Q#*flL=", "asy`4I;=[A", "A~`f5E:sQL", "Z7l;M98*PV" };

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
        new MyJVMTest_5749().checkName(name, comps);
    }
}
