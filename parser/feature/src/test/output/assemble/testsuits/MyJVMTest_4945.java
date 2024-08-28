public class MyJVMTest_4945 {

    static int increment = 0;

    static byte[] elems = new byte[64];

    static int offset = 0;

    int expandIfNeeded(int increment) {
        if (offset + increment > elems.length) {
            int newsize = elems.length * 2;
            while (offset + increment > newsize) {
                newsize *= 2;
            }
            byte[] newelems = new byte[newsize];
            System.arraycopy(elems, 0, newelems, 0, offset);
            elems = newelems;
        }
        return increment;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4945().expandIfNeeded(increment);
    }
}
