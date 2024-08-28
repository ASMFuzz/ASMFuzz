public class MyJVMTest_5550 {

    static String size = ";rlQN4vGE\\";

    static int K = 1024;

    int parseSize(String size) throws Exception {
        if (size.equals("DEFAULT"))
            return (int) Runtime.getRuntime().maxMemory();
        if (size.equals("DEFAULT+1"))
            return (int) Runtime.getRuntime().maxMemory() + 1;
        if (size.equals("DEFAULT+1M"))
            return (int) Runtime.getRuntime().maxMemory() + (1 << 20);
        if (size.equals("DEFAULT-1"))
            return (int) Runtime.getRuntime().maxMemory() - 1;
        if (size.equals("DEFAULT/2"))
            return (int) Runtime.getRuntime().maxMemory() / 2;
        int idx = 0, len = size.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(size.charAt(i)))
                idx++;
            else
                break;
        }
        if (idx == 0)
            throw new RuntimeException("No digits detected: " + size);
        int result = Integer.parseInt(size.substring(0, idx));
        if (idx < len) {
            for (int i = idx; i < len; i++) {
                switch(size.charAt(i)) {
                    case 'T':
                    case 't':
                        result *= K;
                    case 'G':
                    case 'g':
                        result *= K;
                    case 'M':
                    case 'm':
                        result *= K;
                    case 'K':
                    case 'k':
                        result *= K;
                        break;
                    default:
                        throw new RuntimeException("Unrecognized size: " + size);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5550().parseSize(size));
    }
}
