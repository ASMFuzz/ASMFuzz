import java.io.*;

public class MyJVMTest_5503 {

    static String fParam1Param1 = "`(Bd\\S-<CL";

    static String fParam1Param2 = "*L+$wPmG>p";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "9U*1Z{sg3y";

    static File f = new File(fParam1, fParam2);

    String read(File f) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader(f));
        try {
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
        } finally {
            in.close();
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5503().read(f));
    }
}
