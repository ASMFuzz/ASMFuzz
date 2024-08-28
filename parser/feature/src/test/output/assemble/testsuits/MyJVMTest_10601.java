import java.util.*;

public class MyJVMTest_10601 {

    void timestampTest() throws Exception {
        UUID test = UUID.randomUUID();
        try {
            test.timestamp();
            throw new Exception("Expected exception not thrown");
        } catch (UnsupportedOperationException uoe) {
        }
        test = UUID.fromString("00000001-0000-1000-8a5a-be785f17dcda");
        if (test.timestamp() != 1)
            throw new Exception("Incorrect timestamp");
        test = UUID.fromString("00000400-0000-1000-8a5a-be785f17dcda");
        if (test.timestamp() != 1024)
            throw new Exception("Incorrect timestamp");
        test = UUID.fromString("FFFFFFFF-FFFF-1FFF-8a5a-be785f17dcda");
        if (test.timestamp() != Long.MAX_VALUE >> 3)
            throw new Exception("Incorrect timestamp");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10601().timestampTest();
    }
}
