import java.util.*;

public class MyJVMTest_17060 {

    static String diagnostic = "k'Zz.#RY:9";

    static boolean failure = false;

    String fail(String diagnostic) {
        new Error(diagnostic).printStackTrace();
        failure = true;
        return diagnostic;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17060().fail(diagnostic);
    }
}
