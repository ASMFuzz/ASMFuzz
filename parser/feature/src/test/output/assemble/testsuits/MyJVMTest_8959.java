public class MyJVMTest_8959 {

    static String original = "T+WqrFNj;`";

    static boolean laxLineEndings = true;

    static int end = 9;

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
        System.out.println(new MyJVMTest_8959().quote(original));
    }
}
