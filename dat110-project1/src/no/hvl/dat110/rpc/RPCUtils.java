package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;
		
		// TODO: marshall RPC identifier and string into byte array
		encoded=new byte[str.getBytes().length+1];
		encoded[0]=rpcid;
		byte[] bStr=str.getBytes();
		
		for(int i=1; i<encoded.length; i++) {
			encoded[i]=bStr[i-1];
		}
		
		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;
		
		byte[] bStr=new byte[data.length-1];
		for(int i=1;i<data.length;i++) {
			bStr[i-1]=data[i];
		}
		decoded=new String(bStr);
		
		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		encoded=new byte[1];
		encoded[0]=rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		//DONE?
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;
		
		byte[] bX = ByteBuffer.allocate(4).putInt(x).array();
		// TODO: marshall RPC identifier and string into byte array
		encoded=new byte[bX.length+1];
		encoded[0]=rpcid;
		for(int i=1;i<encoded.length;i++) {
			encoded[i]=bX[i-1];
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		byte[] bX=new byte[data.length-1];
		
		for(int i=0;i<bX.length;i++) {
			bX[i]=data[i+1];
		}
		decoded = ByteBuffer.wrap(bX).getInt();
		return decoded;
	}
}