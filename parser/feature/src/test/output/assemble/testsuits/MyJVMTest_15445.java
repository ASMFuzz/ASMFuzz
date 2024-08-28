import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class MyJVMTest_15445 {

    static boolean status = true;

    static boolean[] passedArray = {false,false,false,true,false,false,true,false,true,true};

    static int fi = 0;

    boolean notifyTransferSuccess(boolean status) {
        passedArray[fi] = status;
        fi++;
        return status;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15445().notifyTransferSuccess(status);
    }
}
