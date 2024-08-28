public class MyJVMTest_7558 {

    static ProcessBuilder pb = new ProcessBuilder();

    ProcessBuilder print(ProcessBuilder pb) {
        if (pb != null) {
            System.out.printf(" pb: %s%n", pb);
            System.out.printf("    cmd: %s%n", pb.command());
        }
        return pb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7558().print(pb);
    }
}
