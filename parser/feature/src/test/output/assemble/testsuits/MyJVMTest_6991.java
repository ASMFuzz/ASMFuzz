public class MyJVMTest_6991 {

    static String[] args = { "Ijry_,R!mh", "~gE~*a8iw(", "!,vb=b{Z]!", "^h5HtY(W)P", "<xW:zYrbn3", "a8X g)N:I`", "<,&$Kx9xwF", "A`<rsiOM/d", ",qt1W]+c/f", "|ybbS)# %/" };

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
        new MyJVMTest_6991().foo(args);
    }
}
