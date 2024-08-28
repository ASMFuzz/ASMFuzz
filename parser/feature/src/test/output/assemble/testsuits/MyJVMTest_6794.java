public class MyJVMTest_6794 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int pos = 0;

    E next() {
        return elements[pos++];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6794().next());
    }
}
