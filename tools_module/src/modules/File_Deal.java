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
	
	/*1.Java的FileInputStream类本身就是字节流读取文件方式，配合InputStreamReder类，转换成了字符流读取；
	 * 	也就是说，InputStreamReder类是字节流读取向字符流读取转换的桥梁；
	 *2.Java的FileInputStream类配合BufferedReader类和InputStreamReder类，就变成了按行读取；
	 *	注意：无论哪种按行读取，其基本数据单元都是字符，而不是字节；
	 *3.Java的FileInputStream类默认的编码方式不是文件的编码方式，而是系统默认的的编码方式（一般为GBK）
	 *4.Java读取文件及字符集编码问题，详细介绍参照自己的github文档；
	 *5.下面说明各种常用读取方式的实例：*/
	
	//InputStreamReder，FileInputStream，BufferedReader三个类配合读取——字符流按行读取
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
		
		//写入新的文件，可设置写入的字符集编码，作为字符流写入，还有一种直接用BufferedWriter类写入的方式，后面补充介绍
		//https://www.cnblogs.com/x_wukong/p/4679116.html
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
	
	/*1.FileReader类是InputStreamReader类的子类，所有的方法都从父类InputStreamReader中继承；
	 *2.由于InputStreamReader类是字符流转换桥梁，所以FileReader类读取也是字符流读取文件*/
	
}
