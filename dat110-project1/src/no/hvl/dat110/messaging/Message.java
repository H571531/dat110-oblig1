package no.hvl.dat110.messaging;

import java.util.Arrays;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded;
		
		// TODO
		// encapulate/encode the payload of the message
		encoded = new byte[payload.length+1];
		encoded[0]=(byte)payload.length;
		for(int i=1; i<payload.length;i++) {
			encoded[i]=payload[i-1];
		}		
		
		
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate data in received and put in payload
		for(int i=1; i<received[0];i++) {
			payload[i-1]=received[i];
		}
	   
		
	}
}
