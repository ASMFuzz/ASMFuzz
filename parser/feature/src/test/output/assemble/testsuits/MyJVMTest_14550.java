public class MyJVMTest_14550 {

    static int SIZE = 30;

    static boolean bol = true;

    int f() {
        int[] a = new int[SIZE];
        if (bol)
            a[0] = 0;
        if (bol)
            a[1] = 1;
        if (bol)
            a[2] = 2;
        if (bol)
            a[3] = 3;
        if (bol)
            a[4] = 4;
        if (bol)
            a[5] = 5;
        if (bol)
            a[6] = 6;
        if (bol)
            a[7] = 7;
        if (bol)
            a[8] = 8;
        if (bol)
            a[9] = 9;
        if (bol)
            a[10] = 10;
        if (bol)
            a[11] = 11;
        if (bol)
            a[12] = 12;
        if (bol)
            a[13] = 13;
        if (bol)
            a[14] = 14;
        if (bol)
            a[15] = 15;
        if (bol)
            a[16] = 16;
        if (bol)
            a[17] = 17;
        if (bol)
            a[18] = 18;
        if (bol)
            a[19] = 19;
        if (bol)
            a[20] = 20;
        if (bol)
            a[21] = 21;
        if (bol)
            a[22] = 22;
        if (bol)
            a[23] = 23;
        if (bol)
            a[24] = 24;
        if (bol)
            a[25] = 25;
        if (bol)
            a[26] = 26;
        if (bol)
            a[27] = 27;
        if (bol)
            a[28] = 28;
        if (bol)
            a[29] = 29;
        return a[12];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14550().f());
    }
}
