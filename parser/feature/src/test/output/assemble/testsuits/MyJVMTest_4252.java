import java.nio.charset.*;

public class MyJVMTest_4252 {

    static Charset cs1 = null;

    static Charset cs2 = null;

    static boolean cont = true;

    Charset ck(Charset cs1, Charset cs2, boolean cont) throws Exception {
        if ((cs1.contains(cs2)) != cont)
            throw new Exception("Wrong answer: " + cs1.name() + " contains " + cs2.name());
        System.err.println(cs1.name() + (cont ? " contains " : " does not contain ") + cs2.name());
        return cs2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4252().ck(cs1, cs2, cont);
    }
}
