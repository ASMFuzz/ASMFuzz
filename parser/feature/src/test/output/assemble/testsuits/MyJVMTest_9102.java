public class MyJVMTest_9102 {

    static int n = -1198920508;

    static char c = Character.MIN_VALUE;

    static boolean laxLineEndings = true;

    static int end = 0;

    String fill(int n, char c) {
        StringBuilder result = new StringBuilder(n);
        while (n-- > 0) result.append(c);
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9102().fill(n, c));
    }
}
