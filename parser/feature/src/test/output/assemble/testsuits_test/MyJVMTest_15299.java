public class MyJVMTest_15299 {

    static int j = 0;

    static char c = Character.MAX_VALUE;

    static boolean b = true;

    int check(int j, char c, boolean b) throws Exception {
        if (this.j != j || this.c != c || this.b != b) {
            throw new Exception("error3");
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15299().check(j, c, b);
    }
}
