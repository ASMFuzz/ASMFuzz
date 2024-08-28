import java.io.*;

public class MyJVMTest_13372 {

    void runTest() throws Exception {
        String cmd = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java" + " -classpath " + System.getProperty("test.classes");
        Process process = Runtime.getRuntime().exec(cmd + " DeleteOnExitNPE -test");
        BufferedReader isReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader esReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        process.waitFor();
        boolean failed = false;
        String str;
        while ((str = isReader.readLine()) != null) {
            failed = true;
            System.out.println(str);
        }
        while ((str = esReader.readLine()) != null) {
            failed = true;
            System.err.println(str);
        }
        if (failed)
            throw new RuntimeException("Failed: No output should have been received from the process");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13372().runTest();
    }
}
