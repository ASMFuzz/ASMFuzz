public class MyJVMTest_1334 {

    static int val = 0;

    int testRorOrInt1And(int val) {
        return val & ((val >>> 1) | (val << (32 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1334().testRorOrInt1And(val));
    }
}
