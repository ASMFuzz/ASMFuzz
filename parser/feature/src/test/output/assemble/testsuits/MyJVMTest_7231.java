import java.io.File;

public class MyJVMTest_7231 {

    static String[] args = { "ljv8W'~2)A", "1D]Jv586Q/", "iMu5mKn['O", "`bRH)Be?$V", "?-\"?h&WMd=", "te_ld{?\"~x", "DnR8i!?mNJ", "NMeV77f;'W", "8PBlHY.o3&", "n_i+.bIowE" };

    static boolean removeSource = false;

    int parseOptions(String[] args) {
        int optionsEnd = 0;
        while (args[optionsEnd].startsWith("-")) {
            switch(args[optionsEnd].substring(1)) {
                case "r":
                    removeSource = true;
                    break;
                default:
                    throw new RuntimeException("Unrecognized option passed to CopyClassFile: " + args[optionsEnd]);
            }
            optionsEnd++;
        }
        return optionsEnd;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7231().parseOptions(args));
    }
}
