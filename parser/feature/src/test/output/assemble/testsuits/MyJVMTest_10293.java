import java.util.*;
import javax.net.ssl.*;

public class MyJVMTest_10293 {

    static String[] suites = { "(>D:JM;?Z,", "|sDic@xQ)+", "2*H7B2T%*d", "5,9o!gwSY&", "|yT|rkiVlt", "R*]{t#eO=D", "b2Z9/@ck#5", "xC'v\\Z'_W\\", "+]Yd`jU[&5", "P^]1vmScXY" };

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
        new MyJVMTest_10293().showSuites(suites);
    }
}
