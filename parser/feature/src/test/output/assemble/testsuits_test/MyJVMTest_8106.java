public class MyJVMTest_8106 {

    static Integer i = 0;

    String m(Integer i) {
        return "Integer " + i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8106().m(i));
    }
}
