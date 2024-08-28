import javax.crypto.*;
import java.nio.file.*;
import java.util.stream.*;

public class MyJVMTest_3958 {

    String getDefaultPolicy() throws Exception {
        String javaHome = System.getProperty("java.home");
        Path path = Paths.get(javaHome, "conf", "security", "java.security");
        try (Stream<String> lines = Files.lines(path)) {
            return lines.filter(x -> x.startsWith("crypto.policy=")).findFirst().orElseThrow(() -> new Exception("Missing crypto.policy")).split("=")[1].trim();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3958().getDefaultPolicy());
    }
}
