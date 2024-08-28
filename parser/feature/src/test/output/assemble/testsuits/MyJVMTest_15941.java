import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;
import java.sql.Date;

public class MyJVMTest_15941 {

    static long sParam1 = 9223372036854775807L;

    static Date s = new Date(sParam1);

    static int eParam1 = 814;

    static int eParam2 = 581;

    static int eParam3 = 609;

    static Date e = new Date(eParam1, eParam2, eParam3);

    long millsec(Date s, Date e) {
        long ts = s.getTime();
        long te = e.getTime();
        return te - ts;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15941().millsec(s, e));
    }
}
