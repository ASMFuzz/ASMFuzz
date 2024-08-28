public class MyJVMTest_16505 {

    static String[] args = { "OsL!*YlEB4", "Wh6AkrIx,1", "ukB55lT=he", "{?r' ?EO++", "cGz6_Yy)!Y", "-nDNR5W>e&", "`aQ9|lPYTY", "evbZ Vy{Ah", "#Kw/*!Oy(V", "};XtisD9jm" };

    int foo(String[] args) {
        int index = -1;
        try {
            args[index] = "Invalid index";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception expected");
        } finally {
            System.out.println("Good bye");
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16505().foo(args);
    }
}
