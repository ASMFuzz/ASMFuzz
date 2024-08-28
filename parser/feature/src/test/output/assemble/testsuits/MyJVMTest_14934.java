import java.io.*;
import java.net.URI;

public class MyJVMTest_14934 {

    static String fParam1Param1 = "H{ji:;1niU";

    static String fParam1Param2 = "Ot(wW>:[<^";

    static String fParam1Param3 = "gK^;=<n_F#";

    static String fParam1Param4 = "mE=_P?>}`s";

    static String fParam1Param5 = "Sb#{[e>\"M/";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3, fParam1Param4, fParam1Param5);

    static File f = new File(fParam1);

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
        System.out.println(new MyJVMTest_14934().read(f));
    }
}
