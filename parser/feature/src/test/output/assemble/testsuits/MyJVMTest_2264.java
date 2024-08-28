import java.time.ZoneId;
import java.time.zone.ZoneRules;

public class MyJVMTest_2264 {

    static String zoneId = "3/5+=CiuC{";

    static boolean forCaching = false;

    ZoneRules provideRules(String zoneId, boolean forCaching) {
        return ZoneId.of("UTC").getRules();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2264().provideRules(zoneId, forCaching));
    }
}
