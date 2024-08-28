import java.util.ArrayList;

public class MyJVMTest_12037 {

    static ArrayList<String> prefix = new ArrayList<String>();

    static ArrayList<String> disabledRuntimePrefixes = new ArrayList<>();

    ArrayList<String> getRuntimePrefix() {
        ArrayList<String> cmdline = new ArrayList<>();
        String jtropts = System.getProperty("test.cds.runtime.options");
        if (jtropts != null) {
            for (String s : jtropts.split(",")) {
                if (!disabledRuntimePrefixes.contains(s)) {
                    cmdline.add(s);
                }
            }
        }
        for (String p : prefix) {
            cmdline.add(p);
        }
        return cmdline;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12037().getRuntimePrefix());
    }
}
