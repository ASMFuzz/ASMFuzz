import java.io.*;
import java.net.*;
import java.applet.Applet;

public class MyJVMTest_10070 {

    int getTimeToLive() throws IOException {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10070().getTimeToLive());
    }
}
