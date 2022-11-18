package day20;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Wrting_Data {

	public static void main(String[] args) {
		
		//small_data();
		large_data();
	}

	private static void large_data() {
		
		try(RandomAccessFile file = new RandomAccessFile("src/names.txt", "rw")) {
			String data = """
					import java.io.RandomAccessFile;
					import java.nio.ByteBuffer;
					import java.nio.MappedByteBuffer;
					import java.nio.channels.FileChannel;
					""";
			//1
			FileChannel channel = file.getChannel();
			
			//2
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024 * 10);
			
			// write to buffer
			buffer.put(data.getBytes());
			
			System.out.println("save data..");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static void small_data() {
try(RandomAccessFile file = new RandomAccessFile("src/languages.txt", "rw")) {
			
			String data = """
					1. Java
					2. Php
					3. Javascript
					4. Database
					5. Laravel
					""";
			byte[] output = data.getBytes();
			
			FileChannel channel = file.getChannel();
			
			// create buffer
			ByteBuffer buffer = ByteBuffer.allocate(output.length);
			
			
			// write to buffer
			buffer.put(output);
			
			// flip
			buffer.flip();
			
			// save data to the file
			channel.write(buffer);
			
			System.out.println("save data");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
