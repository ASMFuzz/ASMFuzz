public class MyJVMTest_2730 {

    static String original = "LO+3l$IwGq";

    String trimDoubleQuotes(String original) {
        if (original == null) {
            return null;
        }
        String trimmed = original.replaceAll("^\"+|\"+$", "");
        return trimmed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2730().trimDoubleQuotes(original));
    }
}
