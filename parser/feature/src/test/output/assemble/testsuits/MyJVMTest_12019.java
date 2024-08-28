public class MyJVMTest_12019 {

    static String original = "lN5z$$G~Gg";

    String trimDoubleQuotes(String original) {
        if (original == null) {
            return null;
        }
        String trimmed = original.replaceAll("^\"+|\"+$", "");
        return trimmed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12019().trimDoubleQuotes(original));
    }
}
