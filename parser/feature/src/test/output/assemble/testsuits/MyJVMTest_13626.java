import java.io.*;
import java.util.*;
import java.security.cert.*;
import sun.security.provider.certpath.*;

public class MyJVMTest_13626 {

    static String fileName = "=k*-eq\":8a";

    static File testDir = new File(System.getProperty("test.src", "."));

    String readFile(String fileName) throws IOException {
        String filePath = testDir + "/" + fileName;
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().startsWith("#")) {
                    sb.append(line).append("\n");
                }
            }
        }
        System.out.println("Successfully read " + fileName);
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13626().readFile(fileName));
    }
}
