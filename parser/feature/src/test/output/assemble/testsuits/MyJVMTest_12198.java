import java.util.*;

public class MyJVMTest_12198 {

    static String key = "!6[\\>R,-u;";

    Object handleGetObject(String key) throws MissingResourceException {
        if (key.equals("Time"))
            return "Time keeps on slipping...";
        else if (key.equals("For"))
            return "Four score and seven years ago...";
        else if (key.equals("All")) {
            String[] values = { "'Twas brillig, and the slithy toves", "Did gyre and gimble in the wabe.", "All mimsy were the borogoves,", "And the mome raths outgrabe." };
            return values;
        } else if (key.equals("Good"))
            return new Integer(3);
        else
            return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12198().handleGetObject(key));
    }
}
