import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class MyJVMTest_12603 {

    static String args = "*%T/81D@+I";

    List<String> run_javac(String... args) throws IOException, InterruptedException {
        File javaHome = new File(System.getProperty("java.home"));
        File javac = new File(new File(javaHome, "bin"), "javac");
        List<String> opts = new ArrayList<>();
        opts.add(javac.getPath());
        String toolOpts = System.getProperty("test.tool.vm.opts");
        if (toolOpts != null && !"".equals(toolOpts.trim())) {
            opts.addAll(Arrays.asList(toolOpts.trim().split("[\\s]+")));
        }
        opts.addAll(Arrays.asList(args));
        System.out.println("exec: " + opts);
        ProcessBuilder pb = new ProcessBuilder(opts);
        pb.redirectErrorStream();
        Process p = pb.start();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = r.readLine()) != null) System.out.println();
        }
        int rc = p.waitFor();
        if (rc != 0)
            System.out.println("javac exited, rc=" + rc);
        return opts;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12603().run_javac(args);
    }
}
