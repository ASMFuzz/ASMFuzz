import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;
import java.sql.Date;

public class MyJVMTest_6453 {

    static int sParam1 = 863;

    static int sParam2 = 196;

    static int sParam3 = 217;

    static Date s = new Date(sParam1, sParam2, sParam3);

    static long eParam1 = 9223372036854775807L;

    static Date e = new Date(eParam1);

    long millsec(Date s, Date e) {
        long ts = s.getTime();
        long te = e.getTime();
        return te - ts;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6453().millsec(s, e));
    }
}
