import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_5925 {

    void roundtripTest() throws Exception {
        byte[] ba;
        char[] pair = new char[2];
        for (char high = '\ud800'; high <= '\udbff'; high++) {
            for (char low = '\udc00'; low <= '\udfff'; low++) {
                pair[0] = high;
                pair[1] = low;
                String s = new String(pair);
                if (!s.equals(new String(s.getBytes("gb18030"), "gb18030")))
                    throw new Exception("GB18030 roundtrip failure");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5925().roundtripTest();
    }
}
