public class MyJVMTest_10113 {

    static E other = null;

    int compareTo(E other) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10113().compareTo(other));
    }
}
