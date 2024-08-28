public class MyJVMTest_3447 {

    static int n = 2;

    static char c = '0';

    static boolean laxLineEndings = false;

    static int end = 1838706063;

    String fill(int n, char c) {
        StringBuilder result = new StringBuilder(n);
        while (n-- > 0) result.append(c);
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3447().fill(n, c));
    }
}
