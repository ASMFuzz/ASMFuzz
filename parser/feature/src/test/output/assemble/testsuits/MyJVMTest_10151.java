import java.text.*;
import java.util.*;

public class MyJVMTest_10151 {

    static String fmt = "f8e_[3LYYd";

    int roundtripTest(String fmt) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Date date = new Date();
        int fractionalHour = sdf.getTimeZone().getOffset(date.getTime());
        fractionalHour %= 3600000;
        String s = sdf.format(date);
        Date pd = sdf.parse(s);
        long diffsInMillis = pd.getTime() - date.getTime();
        if (diffsInMillis != 0) {
            if (diffsInMillis != fractionalHour) {
                throw new RuntimeException("fmt= " + fmt + ", diff=" + diffsInMillis + ", fraction=" + fractionalHour);
            }
        }
        return fractionalHour;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10151().roundtripTest(fmt);
    }
}
