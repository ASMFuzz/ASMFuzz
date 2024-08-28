public class MyJVMTest_6760 {

    static long id = 5140185260514759133L;

    long nextId() {
        return id++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6760().nextId());
    }
}
