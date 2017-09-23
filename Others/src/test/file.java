package test;

import java.io.File;
import java.io.IOException;

public class file {
		public static void main(String[] args) {
				File f=new File("d:/");
				print(f,0);
				
}
		
		static void print(File file,int l){
			for(int i=0;i<l;i++){
				System.out.print("-");
			}
			System.out.println(file.getName());
			
			if(file.isDirectory()){
				File[] files=file.listFiles();
				for(File t:files){
					print(t,l+1);
				}
			}
		}
}
