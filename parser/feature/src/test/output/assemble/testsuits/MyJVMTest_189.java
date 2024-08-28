import java.io.*;
import java.util.*;
import java.security.*;
import java.security.cert.*;

public class MyJVMTest_189 {

    static Key p1 = null;

    static Key p2 = null;

    Key match(Key p1, Key p2) throws Exception {
        System.out.println(String.valueOf(p2).split("\\n")[0]);
        if ((p1 != p2) && (p1.equals(p2) == false)) {
            throw new Exception("Private key mismatch");
        }
        return p2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_189().match(p1, p2);
    }
}
