import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_4436 {

    boolean encodeTest6730652() throws Exception {
        String strCNSP3 = "\u4e28\u4e36\u4e3f\u4e85\u4e05\u4e04\u5369\u53b6\u4e2a\u4e87\u4e49\u51e2\u56b8\u56b9\u56c4\u8053\u92b0";
        return strCNSP3.equals(new String(strCNSP3.getBytes("x-ISO-2022-CN-CNS"), "x-ISO-2022-CN-CNS"));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4436().encodeTest6730652());
    }
}
