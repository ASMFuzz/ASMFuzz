import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_5990 {

    static boolean status = false;

    static boolean[] passedArray = {false,true,true,true,true,true,false,true,true,false};

    static int fi = 0;

    boolean notifyTransferSuccess(boolean status) {
        passedArray[fi] = status;
        fi++;
        return status;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5990().notifyTransferSuccess(status);
    }
}
