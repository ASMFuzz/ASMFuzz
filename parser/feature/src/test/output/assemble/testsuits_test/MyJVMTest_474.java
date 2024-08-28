import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;
import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.tools.*;

public class MyJVMTest_474 {

    static Set<? extends TypeElement> tes = new HashSet<? extends TypeElement>();

    static RoundEnvironment renv = null;

    static File processed = new File("processed");

    boolean process(Set<? extends TypeElement> tes, RoundEnvironment renv) {
        try {
            new FileWriter(processed).close();
        } catch (IOException e) {
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_474().process(tes, renv));
    }
}
