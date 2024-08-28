public class MyJVMTest_16423 {

    static int i = 9;

    static String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

    Object getElementAt(int i) {
        return strings[i];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16423().getElementAt(i));
    }
}
