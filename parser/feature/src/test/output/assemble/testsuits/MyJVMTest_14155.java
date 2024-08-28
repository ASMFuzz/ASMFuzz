import java.util.*;

public class MyJVMTest_14155 {

    static String options = "N?1A57(|0<";

    static TreeMap<String, String[]> optionMap = null;

    String[] setOptionMap(String options) {
        TreeMap<String, String[]> optmap = new TreeMap<String, String[]>();
        loadOptmap: for (String optline : options.split("\n")) {
            String[] words = optline.split("\\p{Space}+");
            if (words.length == 0) {
                continue loadOptmap;
            }
            String opt = words[0];
            words[0] = "";
            if (opt.length() == 0 && words.length >= 1) {
                opt = words[1];
                words[1] = "";
            }
            if (opt.length() == 0) {
                continue loadOptmap;
            }
            String[] prevWords = optmap.put(opt, words);
            if (prevWords != null) {
                throw new RuntimeException("duplicate option: " + optline.trim());
            }
        }
        optionMap = optmap;
        return words;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14155().setOptionMap(options);
    }
}
