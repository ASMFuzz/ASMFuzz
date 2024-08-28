public class MyJVMTest_5852 {

    static int j = 7;

    static char c = Character.MIN_VALUE;

    static boolean b = true;

    int check(int j, char c, boolean b) throws Exception {
        if (this.j != j || this.c != c || this.b != b) {
            throw new Exception("error3");
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5852().check(j, c, b);
    }
}
