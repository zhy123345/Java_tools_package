package modules;

import java.io.IOException;

public class Modules_Main {
	
	public static void main(String[] args) {
		
		/**1.数组列表的差集ArrayList_operation*/
		//ArrayList_operation.Differential_Set();
		
		/**2.读取文件的方式——字节流和字符流，以及对应的字符集编码问题*/
		//字节流转换为字符流按行读取；以及写入新的文件，字节流转换为字符流写入，可设置写入的字符集编码
		FileDeal.TransformationCharacterStream();
		
		//FileReader类按行读取，即直接字符流读取
		FileDeal.CharacterStream();
		
		//字节流读取，一次读取多个字节；也是二进制读取文件
		try {
			FileDeal.BinaryStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
