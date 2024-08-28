public class MyJVMTest_4030 {

    static boolean bol = true;

    int f() {
        int i = 0;
        if (bol)
            i = 1;
        else if (bol)
            i = 2;
        else if (bol)
            i = 3;
        else if (bol)
            i = 4;
        else if (bol)
            i = 5;
        else if (bol)
            i = 6;
        else if (bol)
            i = 7;
        else if (bol)
            i = 8;
        if (bol)
            i = 1;
        else if (bol)
            i = 2;
        else if (bol)
            i = 3;
        else if (bol)
            i = 4;
        else if (bol)
            i = 5;
        else if (bol)
            i = 6;
        else if (bol)
            i = 7;
        else if (bol)
            i = 8;
        if (bol)
            i = 1;
        else if (bol)
            i = 2;
        else if (bol)
            i = 3;
        else if (bol)
            i = 4;
        else if (bol)
            i = 5;
        else if (bol)
            i = 6;
        else if (bol)
            i = 7;
        else if (bol)
            i = 8;
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4030().f());
    }
}
