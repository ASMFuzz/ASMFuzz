import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_12972 {

    static File file = null;

    boolean isFileNameCaseSignificant() {
        File lower = new File("test.txt");
        File upper = new File(lower.getPath().toUpperCase());
        return !lower.equals(upper);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12972().isFileNameCaseSignificant());
    }
}
