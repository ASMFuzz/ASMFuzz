public class MyJVMTest_12689 {

    static int i = 6;

    static int id = 0;

    boolean complyWith(int i) {
        return id == i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12689().complyWith(i));
    }
}
