public class MyJVMTest_10806 {

    static int index = 1;

    Object getElementAt(int index) {
        return "Element " + index;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10806().getElementAt(index));
    }
}
