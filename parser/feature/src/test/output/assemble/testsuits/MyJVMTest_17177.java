import java.io.BufferedReader;

public class MyJVMTest_17177 {

    static Process p = null;

    static BufferedReader br = null;

    String textIn() throws Exception {
        StringBuilder sb = new StringBuilder();
        boolean isEmpty = true;
        while (true) {
            int i = System.in.read();
            if (i == -1) {
                break;
            }
            isEmpty = false;
            if (i == '\n') {
                break;
            }
            if (i != 13) {
                sb.append((char) i);
            }
        }
        return isEmpty ? null : sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17177().textIn());
    }
}
