import java.util.*;

public class MyJVMTest_13930 {

    static byte[] bytecode = { -61, 63, 119, -80, -4, -3, -103, 126, -114, 52 };

    static Map<byte[], byte[]> dictionary = new HashMap<>();

    Map.Entry<byte[], byte[]> patch(byte[] bytecode) {
        for (Map.Entry<byte[], byte[]> entry : dictionary.entrySet()) {
            for (int i = 0; i + entry.getKey().length < bytecode.length; i++) {
                boolean match = true;
                for (int j = 0; j < entry.getKey().length; j++) {
                    if (bytecode[i + j] != entry.getKey()[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    for (int j = 0; j < entry.getKey().length; j++) bytecode[i + j] = entry.getValue()[j];
                }
            }
        }
        return entry;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13930().patch(bytecode);
    }
}
