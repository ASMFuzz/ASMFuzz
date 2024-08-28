public class MyJVMTest_18015 {

    static int cnt = 1244847852;

    static int[] b = {4,0,-372871862,7,-1069029195,0,0,0,0,2};

    static String s = "lUk0)U|KL7";

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
        System.out.println(new MyJVMTest_18015().test());
    }
}
