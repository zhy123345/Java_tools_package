package read_write_xml;

import java.io.File;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		//String Ciconfig = args[0];
		//String task = args[1];
		String Ciconfig = "CIconfig.xml";
		String task = "task.xml";
		
		//解析CIconfig.xml文件的pclint任务节点
		ArrayList<String> BaseLine_task = analysis_cicloud_task(Ciconfig,task);
		
		//解析cicloud_task.xml文件的任务
		
		
		//云构建任务与基线任务比较，增减更新任务节点
		
		
	}
	
	public static ArrayList<String> analysis_cicloud_task(String Ciconfig,String task) {
		//List是一个接口类，不能构造对象；而ArrayList是一个类，可以创建对象
		ArrayList<String> BaseLine_task = new ArrayList<String>();
		
		try {
			SAXReader reader = new SAXReader();
			File task_file = new File(task);
			Document document = reader.read(task_file);//加载xml文件，获取document对象
			Element root_node = document.getRootElement();//获取document对象根节点
			System.out.println("根节点名" + root_node.getName());
			
			List<Element> sub_nodes_list = root_node.elements();//获取根节点下所有子节点，并把子节点的所有记录存储在列表
			for (Element sub_node : sub_nodes_list) {
				System.out.println("子节点: " + sub_node.getName());
				List<Element> pclint_nodes_list = sub_node.elements();
				for (Element pclint_node : pclint_nodes_list) {
					System.out.println("子节点: " + pclint_node.getName());
					
					
				}
					
					//System.out.println("属性名: " + attr.getName());
					//System.out.println("属性值: " + attr.getValue());
					//这种while加for循环的解析方式，会把子节点多个属性解析出来
					
					
				}
				


		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return BaseLine_task;
	}
	
}
