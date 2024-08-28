import java.io.*;

public class MyJVMTest_8734 {

    static String fParam1 = "0gY/aKMrWz";

    static String fParam2 = "3{%W+GNteV";

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
        System.out.println(new MyJVMTest_8734().read(f));
    }
}
