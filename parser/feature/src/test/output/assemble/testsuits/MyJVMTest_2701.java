public class MyJVMTest_2701 {

    static int i = 5;

    int f() {
        class Local {

            int i = 5;
        }
        return (new Local()).i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2701().f());
    }
}
