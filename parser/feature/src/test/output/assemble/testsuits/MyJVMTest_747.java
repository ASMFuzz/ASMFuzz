import java.util.*;

public class MyJVMTest_747 {

    void clockSequenceTest() throws Exception {
        UUID test = UUID.randomUUID();
        try {
            test.clockSequence();
            throw new Exception("Expected exception not thrown");
        } catch (UnsupportedOperationException uoe) {
        }
        test = UUID.fromString("00000001-0000-1000-8001-be785f17dcda");
        if (test.clockSequence() != 1)
            throw new Exception("Incorrect sequence");
        test = UUID.fromString("00000001-0000-1000-8002-be785f17dcda");
        if (test.clockSequence() != 2)
            throw new Exception("Incorrect sequence");
        test = UUID.fromString("00000001-0000-1000-8010-be785f17dcda");
        if (test.clockSequence() != 16)
            throw new Exception("Incorrect sequence");
        test = UUID.fromString("00000001-0000-1000-bFFF-be785f17dcda");
        if (test.clockSequence() != ((2L << 13) - 1))
            throw new Exception("Incorrect sequence");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_747().clockSequenceTest();
    }
}
