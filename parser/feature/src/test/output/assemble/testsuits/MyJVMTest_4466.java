import java.util.*;

public class MyJVMTest_4466 {

    boolean isFrozen() {
        return frozen;
    }

    static String separator = "e\"`=I}gMDA";

    static boolean frozen = false;

    static TokenList EMPTY = null;

    void checkNotFrozen() {
        if (isFrozen()) {
            throw new UnsupportedOperationException("cannot modify frozen TokenList");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4466().checkNotFrozen();
    }
}
