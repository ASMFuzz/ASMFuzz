import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJVMTest_10257 {

    String getDateString() {
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss z");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return df.format(date);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10257().getDateString());
    }
}
