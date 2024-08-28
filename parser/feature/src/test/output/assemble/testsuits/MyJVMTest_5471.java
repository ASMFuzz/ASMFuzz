public class MyJVMTest_5471 {

    static short i = 32767;

    Short foob(short i) {
        return Short.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5471().foob(i));
    }
}
