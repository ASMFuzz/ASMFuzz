public class MyJVMTest_9627 {

    static String s1 = "(yvJ,4{Nlf";

    static int v1 = 1;

    static int v2 = -1267538407;

    boolean m(String s1) {
        int l = v2 - v1;
        char[] arr = new char[l];
        arr[0] = 'a';
        String s2 = new String(arr);
        return s2.equals(s1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9627().m(s1));
    }
}
