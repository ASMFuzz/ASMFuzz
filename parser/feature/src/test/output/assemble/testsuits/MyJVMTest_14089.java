import java.text.*;

public class MyJVMTest_14089 {

    static String ID = "H*B!sE*<H3";

    static DateFormatSymbols dfs = new DateFormatSymbols();

    int getZoneIndex(String ID, DateFormatSymbols dfs) {
        String[][] zoneStrings = dfs.getZoneStrings();
        for (int index = 0; index < zoneStrings.length; index++) {
            if (ID.equalsIgnoreCase(zoneStrings[index][0]))
                return index;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14089().getZoneIndex(ID, dfs));
    }
}
