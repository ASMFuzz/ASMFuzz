import java.text.*;
import java.util.Locale;

public class MyJVMTest_4694 {

    static String ID = "\\h>Ym@ybk=";

    static String dfsParam1Param1 = "oxg7]exGID";

    static String dfsParam1Param2 = "$C>7@JH%UY";

    static Locale dfsParam1 = new Locale(dfsParam1Param1, dfsParam1Param2);

    static DateFormatSymbols dfs = new DateFormatSymbols(dfsParam1);

    int getZoneIndex(String ID, DateFormatSymbols dfs) {
        String[][] zoneStrings = dfs.getZoneStrings();
        for (int index = 0; index < zoneStrings.length; index++) {
            if (ID.equalsIgnoreCase(zoneStrings[index][0]))
                return index;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4694().getZoneIndex(ID, dfs));
    }
}
