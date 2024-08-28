public class MyJVMTest_3361 {

    static int i = 2;

    static int id = 0;

    boolean complyWith(int i) {
        return id == i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3361().complyWith(i));
    }
}
