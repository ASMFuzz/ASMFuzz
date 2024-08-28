public class MyJVMTest_10536 {

    static String original = "]B@?c5F@t<";

    static boolean laxLineEndings = true;

    static int end = 7;

    String quote(String original) {
        StringBuilder output = new StringBuilder();
        for (char c : original.toCharArray()) {
            if (c < 32) {
                output.append(String.format("\\u%04X", (int) c));
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10536().quote(original));
    }
}
