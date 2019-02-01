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
		
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = (byte) payload.length;
		
		for(int i = 0; i < payload.length; i++) {
			encoded[i+1] = payload[i];
		}
		
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate data in received and put in payload
		
		byte[] decoded = new byte[received[0]];
		
		for(int i = 0; i < decoded.length; i++) {
			decoded[i] = received[i+1];
		}
		
	   payload = decoded;
		
	}
}
