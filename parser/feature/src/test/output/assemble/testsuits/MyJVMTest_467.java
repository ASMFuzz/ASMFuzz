public class MyJVMTest_467 {

    static String s1 = "u*i0((iu|A";

    static int v1 = 9;

    static int v2 = 2;

    boolean m(String s1) {
        int l = v2 - v1;
        char[] arr = new char[l];
        arr[0] = 'a';
        String s2 = new String(arr);
        return s2.equals(s1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_467().m(s1));
    }
}
