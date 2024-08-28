public class MyJVMTest_11764 {

    static int k = 0;

    int howMany(int k) {
        switch(k) {
            case 1:
                System.out.print("one ");
            case 2:
                System.out.print("too ");
            case 3:
                System.out.println("many");
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11764().howMany(k);
    }
}
