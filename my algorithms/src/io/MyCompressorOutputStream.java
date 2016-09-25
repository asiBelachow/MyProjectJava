package io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;



/**
 * The Class MyCompressorOutputStream save a Maze3D object to a output stream 
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-28-08
 */
public class MyCompressorOutputStream  extends OutputStream{

	//------------------------------Data Members-------------------------//
	

	private OutputStream out;
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>MyCompressorOutputStream</h1><p>
	 * <i><ul>MyCompressorOutputStream(OutputStream out)<i><p>
	 * Initialize a new compressor
	 * @param out - OutputStream 
	 */
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
		
	}
	
	//-------------------------Functionality-------------------------//
	
	
	@Override
	public void write(int b) throws IOException {
		
	}
	
	
	@Override
	public void write(byte[] array) throws IOException{
		DataOutputStream data = new DataOutputStream(out);
		int counter = 0;
		byte num = array[0];
	
	for (byte b : array) {
		if(b == num){
		   counter++;	
		}
		else{	
		data.writeByte(num);
		data.writeInt(counter);
		num = b;
		counter = 1;	
		}
		
	}
	
	data.writeByte(num);
	data.writeInt(counter);
		
	}
	
}
