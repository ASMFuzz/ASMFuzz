public class MyJVMTest_11987 {

    static int i = 5;

    int f() {
        class Local {

            int i = 5;
        }
        return (new Local()).i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11987().f());
    }
}
