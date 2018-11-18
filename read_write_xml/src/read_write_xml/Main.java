package read_write_xml;

import java.io.File;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import java.util.Iterator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		//String Ciconfig = args[0];
		//String task = args[1];
		String Ciconfig = "CIconfig.xml";
		String task = "task.xml";
		File Ciconfig_file = new File(Ciconfig);
		File task_file = new File(task);
		
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(Ciconfig_file);//加载xml文件，获取document对象
			Element project_Numbers = document.getRootElement();//获取document对象根节点
			Iterator it = project_Numbers.elementIterator();//获取迭代器
			
			//如果根节点遍历完成，则返回给while循环false
			while (it.hasNext()) {
				Element project = (Element) it.next();//next()方法，指针(光标)指向下一条记录，相当于遍历子节点
				List<Attribute> project_attr_list = project.attributes();//把子节点的所有记录存储在列表
				for (Attribute attr : project_attr_list) {
					System.out.println("属性名: " + attr.getName());
					System.out.println("属性值: " + attr.getValue());
					//这种while加for循环的解析方式，会把子节点多个属性解析出来
					
					
				}
				
				
				
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
}
