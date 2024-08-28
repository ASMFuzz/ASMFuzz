public class MyJVMTest_16296 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int pos = 0;

    E next() {
        return elements[pos++];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16296().next());
    }
}
