package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] hent = RPCUtils.marshallString(RPCID, message);
		
		byte[] tilbake = rmiclient.call(hent);
		
		RPCUtils.unmarshallVoid(tilbake);

	}
}
