package modules;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class File_Deal {
	
	/*1.Java的FileInputStream()方法本身就是字节流读取文件方式，配合InputStreamReder()，转换成了字符流读取；
	 * 	也就是说，InputStreamReder()方法是字节流读取向字符流读取转换的桥梁；
	 *2.Java的FileInputStream()方法配合BufferedReader()方法和InputStreamReder()，就变成了按行读取；
	 *3.Java的FileReader()方法配合BufferedReader()方法，也是按行读取；
	 *	注意：无论哪种按行读取，其基本数据单元都是字符，而不是字节；
	 *4.Java的FileInputStream()默认的编码方式不是文件的编码方式，而是系统默认的的编码方式（一般为GBK）
	 *5.Java读取文件及字符集编码问题，详细介绍参照自己的github文档；
	 *6.下面说明各种常用读取方式的实例：*/
	
	//InputStreamReder()，FileInputStream()，BufferedReader()三种方法配合读取——字符流按行读取
	public static void Read_File_ByteStream() {
		//读取文件
		StringBuffer buffer_obj = new StringBuffer("");
		ArrayList<String> file_content = new ArrayList<String>();
		
		String filename = "Haproxy_Keepalived.txt";
		File file = new File(filename);
		String tempStr = "";
		
		try {
			InputStreamReader isr_obj = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader reader_obj = new BufferedReader(isr_obj);
			while ((tempStr = reader_obj.readLine()) != null) {
				buffer_obj.append(tempStr + "\n");//读取的数据存储在StringBuffer缓存中
				file_content.add(tempStr);//读取的数据存储在数组列表中
			}
			reader_obj.close();
			isr_obj.close();
			}catch (IOException e) {
				//IOException e 可以作为处理万能的异常
				e.printStackTrace();
			}
		System.out.println(buffer_obj.toString());
		System.out.println(file_content);
		
		//写入新的文件
		String aa = "MD5_" + file.getPath();
		File new_file = new File(aa);
		try {
			OutputStreamWriter osw_obj = new OutputStreamWriter(new FileOutputStream(new_file),"GBK");
			BufferedWriter bw = new BufferedWriter(osw_obj);
			bw.write(buffer_obj.toString());
			bw.close();
			osw_obj.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
