package test;

import java.util.Scanner;

public class word {
	public static void main(String[] args) {
		String[] words={"write","program","that"};
		StringBuffer word;
		String singal;
		Scanner scanner=new Scanner(System.in);
		int result=1;
		int error;
		int wrong;
		String choice;
		
		
		for(int i=0;i<words.length;i++){
			word=new StringBuffer("");
			error=0;
			for(int j=0;j<words[i].length();j++){
				word.append("*");
			}
			for(;;){
				System.out.print("输入一个字母");
				singal=scanner.nextLine();
				wrong=word.length();
				for(int k=0;k<words[i].length();k++){
					if(singal.equals(words[i].substring(k,k+1))){
						wrong--;
						if(singal.equals(word.substring(k))){
							System.out.println("已输入");break;
						}else  word.replace(k,k+1,singal);
					}
				}
				if(wrong==word.length()){
					error++;
					System.out.println("输入错误");
				}
				result=1;
				for(int k=0;k<words[i].length();k++){
					if(word.substring(k,k+1).equals("*"))
						result=0;
				}
				if(result==1){
					System.out.println("this is "+word+"   miss"+error);
					break;
				}
				System.out.println(word);
			}
			System.out.println("do you want to go again");
			choice=scanner.nextLine();
			if("n".equals(choice)||"N".equals(choice))
				break;
		}
		
		System.out.println("END");
	}
}
