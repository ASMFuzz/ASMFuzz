import java.util.Arrays;

public class MyJVMTest_9368 {

    static String[] args = { "ve~(\\N&3U8", "47/TQ*\\$y[", "'o;'\\{*XoY", "7\"Y\"D%PK}x", ":1>ZgHB77t", "YQc7DJ?2 >", "M}=f3xd02,", "bVR/%0]57:", "m9\\k}}Q5-z", "J>tE'jhl,b" };

    static String keyword = "(kRGtkVc7{";

    static int[] sofar = {4,991532170,0,9,-205743991,0,0,6,1021692005,5};

    String keywordValue(String[] args, String keyword) {
        for (String arg : args) if (arg.startsWith(keyword))
            return arg.substring(keyword.length() + 1);
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9368().keywordValue(args, keyword));
    }
}
