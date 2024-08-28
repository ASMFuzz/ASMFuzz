public class MyJVMTest_5663 {

    static short i = 32767;

    short simpleb(short i) {
        Short ib = Short.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5663().simpleb(i));
    }
}
