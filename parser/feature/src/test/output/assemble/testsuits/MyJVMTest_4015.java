public class MyJVMTest_4015 {

    static String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

    int getSize() {
        return strings.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4015().getSize());
    }
}
