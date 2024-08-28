public class MyJVMTest_10593 {

    static int size = 0;

    static int index = 0;

    boolean hasNext() {
        return index < size;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10593().hasNext());
    }
}
