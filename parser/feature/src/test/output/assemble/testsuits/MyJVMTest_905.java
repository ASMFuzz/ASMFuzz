import java.util.Random;
import java.util.Arrays;

public class MyJVMTest_905 {

    static int numPorts = 1139338014;

    static int LOWER_BOUND = 49152;

    static int UPPER_BOUND = 65535;

    static Random RND = new Random(System.currentTimeMillis());

    int[] allocatePorts(final int numPorts) {
        int[] ports = new int[numPorts];
        for (int i = 0; i < numPorts; i++) {
            int port = -1;
            while (port == -1) {
                port = RND.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
                for (int j = 0; j < i; j++) {
                    if (ports[j] == port) {
                        port = -1;
                        break;
                    }
                }
            }
            ports[i] = port;
        }
        return ports;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_905().allocatePorts(numPorts)));
    }
}
