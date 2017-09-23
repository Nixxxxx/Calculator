package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class exception {
		public static void main(String[] args) {
			FileReader r=null;
			try {
				r=new FileReader("d:/555.txt");
				char a=(char)r.read();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}finally{
				try {
					if(r!=null){
						r.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
}
