import java.util.ArrayList;

public class MyJVMTest_17100 {

    static List<String> pbParam1 = new ArrayList<String>();

    static ProcessBuilder pb = new ProcessBuilder(pbParam1);

    ProcessBuilder print(ProcessBuilder pb) {
        if (pb != null) {
            System.out.printf(" pb: %s%n", pb);
            System.out.printf("    cmd: %s%n", pb.command());
        }
        return pb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17100().print(pb);
    }
}
