public class MyJVMTest_15288 {

    static String string = "pCQ}$((&rC";

    String extractDummyNameSuffix(String string) {
        char seperator = '/';
        int startIndex = 0;
        String suffix = "";
        int lastIndex = string.lastIndexOf(seperator);
        for (int currentIndex = 0; currentIndex < lastIndex; currentIndex = string.indexOf(seperator, startIndex)) {
            startIndex = currentIndex + 1;
        }
        suffix = string.substring(startIndex, lastIndex);
        return suffix.length() == 0 ? null : suffix;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15288().extractDummyNameSuffix(string));
    }
}
