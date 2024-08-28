public class MyJVMTest_11979 {

    static int i1 = 0;

    static int i2 = 1;

    static int i3 = 0;

    static int i4 = 0;

    static int i5 = 8;

    static int i6 = 0;

    static int i7 = 4;

    static int i8 = 9;

    static int i9 = 0;

    int sum() {
        return i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11979().sum());
    }
}
