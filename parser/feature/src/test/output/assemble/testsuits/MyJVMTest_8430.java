public class MyJVMTest_8430 {

    static int cnt = 0;

    static int[] b = {6,0,9,7,1363737120,9,1,-1790553259,8,0};

    static String s = "PBSCKAyeSA";

    String test() {
        String res = "";
        for (int i = 0; i < cnt; i++) {
            if (i != 0) {
                res = res + ".";
            }
            res = res + b[i];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8430().test());
    }
}
