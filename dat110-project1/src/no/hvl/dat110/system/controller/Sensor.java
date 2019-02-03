package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp;
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		byte[] hent = RPCUtils.marshallVoid(RPCID);
		byte[] tilbake = rmiclient.call(hent);
		temp = RPCUtils.unmarshallInteger(tilbake);
		
		return temp;
	}
	
}
