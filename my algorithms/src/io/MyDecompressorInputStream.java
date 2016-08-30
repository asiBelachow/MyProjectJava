package io;

import java.io.DataInputStream;

import java.io.IOException;
import java.io.InputStream;



/**
 * The Class MyDecompressorInputStream read a Maze3D object from a input stream 
 * 
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-28-08
 */
public class MyDecompressorInputStream extends InputStream {

	private InputStream in;
	
	
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>MyDecompressorInputStream</h1><p>
	 * <i><ul>MyDecompressorInputStream(InputStream in)<i><p>
	 * Initialize a new Decompressor
	 * @param out - InputStream
	 */
	public MyDecompressorInputStream(InputStream in) {
		this.in = in;
	}
	
	@Override
	public int read() throws IOException {
		
		return 0;
	}
	
	@Override
	public int read(byte[] array) throws IOException{
		
		DataInputStream data = new DataInputStream(in);
		
		byte num;
		int i = 0;
		int index;
		
		while (data.available() > 4 && i < array.length){
			num = data.readByte();
			index = data.readInt();
			index += i;

			for (;i < index; i++) {
				array[i] = num ;

			}

		}

		
		return array.length;
	}

}
