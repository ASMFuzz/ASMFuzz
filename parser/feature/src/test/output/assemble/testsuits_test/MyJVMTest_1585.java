public class MyJVMTest_1585 {

    static int index = 0;

    Object getElementAt(int index) {
        return "Element " + index;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1585().getElementAt(index));
    }
}
