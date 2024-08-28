public class MyJVMTest_11876 {

    static short i = 32767;

    short simple(short i) {
        Short ib = new Short(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11876().simple(i));
    }
}
