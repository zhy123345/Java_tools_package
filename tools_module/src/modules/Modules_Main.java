package modules;

import java.io.FileNotFoundException;

public class Modules_Main {
	
	public static void main(String[] args) {
		
		/**1.数组列表的差集ArrayList_operation*/
		//ArrayList_operation.Differential_Set();
		
		/**2.读取文件的方式——字节流和字符流，以及对应的字符集编码问题*/
		//字节流转换为字符流按行读取
		File_Deal.Read_File_Character_Stream();
		//FileReader类按行读取
		//File_Deal.Read_File_FileReader_readline();
		//字节流读取，一次读取多个字节；也是二进制读取文件
		/*
		try {
			File_Deal.Binary_Stream();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
}
