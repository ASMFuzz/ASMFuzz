import java.util.*;

public class MyJVMTest_11076 {

    void nodeTest() throws Exception {
        UUID test = UUID.randomUUID();
        try {
            test.node();
            throw new Exception("Expected exception not thrown");
        } catch (UnsupportedOperationException uoe) {
        }
        test = UUID.fromString("00000001-0000-1000-8001-000000000001");
        if (test.node() != 1)
            throw new Exception("Incorrect node");
        test = UUID.fromString("00000001-0000-1000-8002-FFFFFFFFFFFF");
        if (test.node() != ((2L << 47) - 1))
            throw new Exception("Incorrect node");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11076().nodeTest();
    }
}
