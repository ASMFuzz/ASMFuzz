public class MyJVMTest_12777 {

    static int n = 8;

    static char c = Character.MAX_VALUE;

    static boolean laxLineEndings = true;

    static int end = 1682154822;

    String fill(int n, char c) {
        StringBuilder result = new StringBuilder(n);
        while (n-- > 0) result.append(c);
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12777().fill(n, c));
    }
}
