public class MyJVMTest_8296 {

    static LRProps lrp = null;

    static int limit = 18097;

    static byte[] byteArr = new byte[limit];

    boolean test002(LRProps lrp) {
        char[] a = new char[limit];
        for (int j = 0; j < lrp.iterations; j++) {
            int i = -1;
            while (i < limit) {
                i++;
                if (byteArr[i] == 0x0b) {
                    a[i] = (char) (byteArr[i] + 0x0c);
                } else {
                    int type = lrp.joker;
                    switch(type) {
                        default:
                            return false;
                        case 1:
                            i += 2;
                            break;
                        case 2:
                            i += 3;
                            break;
                    }
                }
            }
        }
        if (a[limit - 1] != 0x0b)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8296().test002(lrp));
    }
}
