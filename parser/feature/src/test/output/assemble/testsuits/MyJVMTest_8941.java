import javax.swing.*;
import java.awt.*;

public class MyJVMTest_8941 {

    static int millis = 0;

    String convertMillisToTimeStr(int millis) {
        if (millis < 0) {
            return "00:00:00";
        }
        int hours = millis / 3600000;
        int minutes = (millis - hours * 3600000) / 60000;
        int seconds = (millis - hours * 3600000 - minutes * 60000) / 1000;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8941().convertMillisToTimeStr(millis));
    }
}
