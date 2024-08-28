import java.io.*;
import java.nio.file.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class MyJVMTest_2470 {

    static int operationID = 1472237263;

    static Map<Integer, List<byte[]>> cache = new HashMap<>();

    String getOperation(int operationID) {
        switch(operationID) {
            case 0x60:
                return "BindRequest";
            case 0x61:
                return "BindResponse";
            case 0x42:
                return "UnbindRequest";
            case 0x63:
                return "SearchRequest";
            case 0x64:
                return "SearchResultEntry";
            case 0x65:
                return "SearchResultDone";
            case 0x66:
                return "ModifyRequest";
            case 0x67:
                return "ModifyResponse";
            case 0x68:
                return "AddRequest";
            case 0x69:
                return "AddResponse";
            case 0x4A:
                return "DeleteRequest";
            case 0x6B:
                return "DeleteResponse";
            case 0x6C:
                return "ModifyDNRequest";
            case 0x6D:
                return "ModifyDNResponse";
            case 0x6E:
                return "CompareRequest";
            case 0x6F:
                return "CompareResponse";
            case 0x50:
                return "AbandonRequest";
            case 0x73:
                return "SearchResultReference";
            case 0x77:
                return "ExtendedRequest";
            case 0x78:
                return "ExtendedResponse";
            case 0x79:
                return "IntermediateResponse";
            default:
                return "Unknown";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2470().getOperation(operationID));
    }
}
