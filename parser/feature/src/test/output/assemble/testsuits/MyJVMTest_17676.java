public class MyJVMTest_17676 {

    static Integer i = 0;

    String m(Integer i) {
        return "Integer " + i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17676().m(i));
    }
}
