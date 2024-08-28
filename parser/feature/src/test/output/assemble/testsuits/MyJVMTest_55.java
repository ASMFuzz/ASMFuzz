import javax.crypto.CipherSpi;

public class MyJVMTest_55 {

    static int inputLen = 374117825;

    int engineGetOutputSize(int inputLen) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_55().engineGetOutputSize(inputLen));
    }
}
