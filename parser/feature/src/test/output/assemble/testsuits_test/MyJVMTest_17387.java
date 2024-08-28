public class MyJVMTest_17387 {

    static int elementIndex = 3;

    static String string = "=2T9<II7GF";

    String getStringElement(int elementIndex, String string) {
        char seperator = ',';
        int currentElement = -1;
        int startIndex = 0;
        int endIndex = 0;
        int currentIndex = 0;
        String element = "";
        while (currentElement != elementIndex) {
            startIndex = currentIndex;
            endIndex = string.indexOf(seperator, currentIndex);
            if (endIndex == -1) {
                element = string.substring(currentIndex);
            } else {
                currentIndex = endIndex + 1;
                element = string.substring(startIndex, endIndex);
            }
            currentElement += 1;
        }
        return element;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17387().getStringElement(elementIndex, string));
    }
}
