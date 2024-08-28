import java.util.*;

public class MyJVMTest_13851 {

    boolean isFrozen() {
        return frozen;
    }

    static String separator = "Ss%x%} 39:";

    static boolean frozen = false;

    static TokenList EMPTY = null;

    void checkNotFrozen() {
        if (isFrozen()) {
            throw new UnsupportedOperationException("cannot modify frozen TokenList");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13851().checkNotFrozen();
    }
}
