package Traverse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TraverseMain {
	
	public static void main(String[] args) {
		//创建收集遍历结果的文件
		String file_list = "F:\\file_list.txt";
		File file_list_obj = new File(file_list);
		try {
			//创建列表文件，并清空内容进行初始化
			file_list_obj.createNewFile();
			FileWriter fw = new FileWriter(file_list_obj);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String input_path = "F:\\dom4j_source_code";
		File input_path_obj = new File(input_path);
		
		//遍历文件及子文件夹下所有文件，并把遍历结果写入到txt文件中
		Traverse_func(file_list_obj, input_path_obj);
		//从文件列表中获取每个文件路径，并读取数据内容
		get_every_file(file_list_obj);
	}
	
	public static void Traverse_func(File file_list_obj, File input_path_obj) {
		File[] file_array = input_path_obj.listFiles();
		for (File file :file_array) {
			if (file.isDirectory()) {
				Traverse_func(file_list_obj, file);
			}
			if (file.isFile()) {
				try {
					FileWriter fw = new FileWriter(file_list_obj,true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(file.getAbsolutePath() + "\n");
					bw.close();
					fw.close();
					//System.out.println(file.getAbsolutePath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void get_every_file(File file_list_obj) {
		
		String tempStr = "";
		try {
			InputStreamReader isr_obj = new InputStreamReader(new FileInputStream(file_list_obj));
			BufferedReader reader_obj = new BufferedReader(isr_obj);
			while ((tempStr = reader_obj.readLine()) != null) {
				StringBuffer buffer_obj = new StringBuffer("");
				buffer_obj.append(tempStr + "\n");//读取的数据存储在StringBuffer缓存中
				
				String every_file = buffer_obj.toString().replace("\n", "");
				File every_file_obj = new File(every_file);
				InputStreamReader isr = new InputStreamReader(new FileInputStream(every_file_obj));
				BufferedReader reader = new BufferedReader(isr);
				
				String temp = "";
				while ((temp = reader.readLine()) != null) {
					StringBuffer buffer = new StringBuffer("");
					buffer.append(temp);
					System.out.println("哈哈");
				}
				reader.close();
				isr.close();
				
				System.out.println(buffer_obj.toString());
			}
			reader_obj.close();
			isr_obj.close();
			
			} catch (IOException e) {
				//IOException e 可以作为处理万能的异常
				e.printStackTrace();
			}
	}
		
}
