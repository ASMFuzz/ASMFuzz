public class MyJVMTest_12991 {

    static boolean bol = true;

    static int i = 6;

    int f() {
        if (bol)
            i = 1;
        if (bol)
            i = 2;
        if (bol)
            i = 3;
        if (bol)
            i = 4;
        if (bol)
            i = 5;
        if (bol)
            i = 6;
        if (bol)
            i = 7;
        if (bol)
            i = 8;
        if (bol)
            i = 1;
        if (bol)
            i = 2;
        if (bol)
            i = 3;
        if (bol)
            i = 4;
        if (bol)
            i = 5;
        if (bol)
            i = 6;
        if (bol)
            i = 7;
        if (bol)
            i = 8;
        if (bol)
            i = 1;
        if (bol)
            i = 2;
        if (bol)
            i = 3;
        if (bol)
            i = 4;
        if (bol)
            i = 5;
        if (bol)
            i = 6;
        if (bol)
            i = 7;
        if (bol)
            i = 8;
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12991().f());
    }
}
