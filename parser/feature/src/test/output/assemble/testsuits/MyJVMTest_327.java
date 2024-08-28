public class MyJVMTest_327 {

    static String string = ":#N-94tGc'";

    String extractJarDummyNameSuffix(String string) {
        char seperator = '/';
        char pling = '!';
        int startIndex = 0;
        String suffix = "";
        int plingIndex = string.lastIndexOf(pling);
        String tempString = string.substring(startIndex, plingIndex);
        int lastIndex = tempString.lastIndexOf(seperator);
        for (int currentIndex = 0; currentIndex < lastIndex; currentIndex = tempString.indexOf(seperator, startIndex)) {
            startIndex = currentIndex + 1;
        }
        suffix = tempString.substring(startIndex, lastIndex);
        return suffix.length() == 0 ? null : suffix;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_327().extractJarDummyNameSuffix(string));
    }
}
