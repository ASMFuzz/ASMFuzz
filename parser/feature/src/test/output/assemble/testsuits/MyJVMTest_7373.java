public class MyJVMTest_7373 {

    static Integer i = 0;

    String m(Integer i) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7373().m(i));
    }
}
