public class MyJVMTest_12376 {

    static int global = 3;

    static int i = 0;

    int f() {
        i = 1;
        global = 8;
        global = 7;
        global = 6;
        global = 5;
        global = 4;
        global = 3;
        global = 2;
        global = 1;
        global = 0;
        global = -1;
        global = -2;
        i = 1;
        global = 8;
        global = 7;
        global = 6;
        global = 5;
        global = 4;
        global = 3;
        global = 2;
        global = 1;
        global = 0;
        global = -1;
        global = -2;
        i = 1;
        global = 8;
        global = 7;
        global = 6;
        global = 5;
        global = 4;
        global = 3;
        global = 2;
        global = 1;
        global = 0;
        global = -1;
        global = -2;
        if (Math.abs(global) >= 0)
            return global;
        return global;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12376().f());
    }
}
