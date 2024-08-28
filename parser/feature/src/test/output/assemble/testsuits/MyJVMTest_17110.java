public class MyJVMTest_17110 {

    static String a = "&fwI+|~~tP";

    static String b = "1jjraep*ph";

    static String[] strings = new String[1024];

    long test_init(String a, String b) {
        for (int i = 0; i < 512; i++) {
            strings[i * 2] = new String(b.toCharArray());
            strings[i * 2 + 1] = new String(a.toCharArray());
        }
        System.out.print(a.length() + " " + b.length() + " ");
        return System.currentTimeMillis();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17110().test_init(a, b));
    }
}
