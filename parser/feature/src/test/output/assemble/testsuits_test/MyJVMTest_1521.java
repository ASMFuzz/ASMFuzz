public class MyJVMTest_1521 {

    static int src1 = 3;

    static int src2 = 3;

    long bzhiI2L(int src1, int src2) {
        switch(src2) {
            case 0:
                return (long) (src1 & 0x1);
            case 1:
                return (long) (src1 & 0x3);
            case 2:
                return (long) (src1 & 0x7);
            case 3:
                return (long) (src1 & 0xF);
            case 4:
                return (long) (src1 & 0x1F);
            case 5:
                return (long) (src1 & 0x3F);
            case 6:
                return (long) (src1 & 0x7F);
            case 7:
                return (long) (src1 & 0xFF);
            case 8:
                return (long) (src1 & 0x1FF);
            case 9:
                return (long) (src1 & 0x3FF);
            case 10:
                return (long) (src1 & 0x7FF);
            case 11:
                return (long) (src1 & 0xFFF);
            case 12:
                return (long) (src1 & 0x1FFF);
            case 13:
                return (long) (src1 & 0x3FFF);
            case 14:
                return (long) (src1 & 0x7FFF);
            case 15:
                return (long) (src1 & 0xFFFF);
            default:
                return (long) (src1 & 0xFFFF);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1521().bzhiI2L(src1, src2));
    }
}
