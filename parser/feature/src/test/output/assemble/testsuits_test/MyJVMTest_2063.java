public class MyJVMTest_2063 {

    static String s1 = "|gDD[KsHu+";

    static int v1 = 0;

    static int v2 = 1;

    int m2(String s1) {
        int l = v2 - v1;
        char[] arr = new char[l + 1];
        arr[0] = 'a';
        arr[1] = 'b';
        String s2 = new String(arr);
        return s2.compareTo(s1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2063().m2(s1));
    }
}
