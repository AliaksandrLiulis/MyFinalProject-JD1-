package resources;

import java.io.IOException;
import java.io.PrintWriter;


import java.io.File;

public class Log {

	private File file = new File("src/resources/log.txt");
	

	public Log() {}
	
	public void writeLog(String str) {
		
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());
			try {
				out.print(str);
				out.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
