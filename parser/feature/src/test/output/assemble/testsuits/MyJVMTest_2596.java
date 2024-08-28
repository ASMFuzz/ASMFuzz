public class MyJVMTest_2596 {

    static short i = -32768;

    short simple(short i) {
        Short ib = new Short(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2596().simple(i));
    }
}
