import java.util.*;

public class MyJVMTest_4542 {

    static byte[] bytecode = { 52, -80, 2, -22, -113, -121, 87, 78, 15, -65 };

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
        new MyJVMTest_4542().patch(bytecode);
    }
}
