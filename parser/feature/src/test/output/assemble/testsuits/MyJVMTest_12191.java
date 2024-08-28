public class MyJVMTest_12191 {

    static Comparable<Boolean> o = null;

    boolean zconv3(Comparable<Boolean> o) {
        return (boolean) o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12191().zconv3(o));
    }
}
