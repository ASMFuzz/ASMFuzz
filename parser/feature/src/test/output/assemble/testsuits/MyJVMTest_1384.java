public class MyJVMTest_1384 {

    void testInt() {
        final int fi = 0;
        Byte b = fi;
        Short s = fi;
        Character c = fi;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1384().testInt();
    }
}
