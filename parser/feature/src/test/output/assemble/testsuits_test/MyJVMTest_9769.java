import java.io.*;

public class MyJVMTest_9769 {

    static String stringA = ";VEL~$Gl>,";

    static String stringB = "xzZ&,Fr{4c";

    static String stringC = "iBq?m}x\\{8";

    static String[] arrayOfString = {"c*khDP%k9V","'0[@kaS|k&","\\{UmEwo_|A","*TN,99^T9p",">}fz\"Q-faV","^} )}+APE`","Df:KLJ`W=P","dF(BVbYb3U","xnnk!M?\\zz","m@+I[iId@-"};

    void report() {
        System.out.println("stringA = " + stringA);
        System.out.println("stringB = " + stringB);
        System.out.println("stringC = " + stringC);
        System.out.println("length of arrayOfString = " + arrayOfString.length);
        for (int i = 0; i < arrayOfString.length; i++) System.out.println("arrayOfString[" + i + "]= " + arrayOfString[i]);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9769().report();
    }
}
