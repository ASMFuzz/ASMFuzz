public class MyJVMTest_16257 {

    static long id = -9223372036854775808L;

    long nextId() {
        return id++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16257().nextId());
    }
}
