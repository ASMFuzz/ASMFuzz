import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_17707 {

    static CoderResult a = null;

    static CoderResult b = null;

    boolean equal(CoderResult a, CoderResult b) {
        return (a == CoderResult.OVERFLOW && b == CoderResult.OVERFLOW) || (a == CoderResult.UNDERFLOW && b == CoderResult.UNDERFLOW) || ((a.isError() == b.isError()) && (a.isMalformed() == b.isMalformed()) && (a.isUnmappable() == b.isUnmappable()) && (a.length() == b.length()));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17707().equal(a, b));
    }
}
