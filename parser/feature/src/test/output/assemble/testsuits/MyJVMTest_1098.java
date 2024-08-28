import java.util.*;
import javax.net.ssl.*;

public class MyJVMTest_1098 {

    static String[] suites = { "oQ6+},6e~&", "/%!{A/nV_A", "ya2a51zE_0", " ht,3X,RE|", "18\"@ni_:|S", "A_YP>Z@&~u", "d|9C%.+:Oc", "yt#xKJAAmT", "##]n6w|;'%", "!]V\\#g_U<g" };

    String[] showSuites(String[] suites) {
        if ((suites == null) || (suites.length == 0)) {
            System.out.println("<none>");
        }
        for (int i = 0; i < suites.length; i++) {
            System.out.println("  " + suites[i]);
        }
        return suites;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1098().showSuites(suites);
    }
}
