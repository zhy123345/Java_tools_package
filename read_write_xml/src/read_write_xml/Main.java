package read_write_xml;

import java.io.File;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		//String Ciconfig = args[0];
		//String task = args[1];
		String CIconfig = "CIconfig.xml";
		String cicloud_task = "task.xml";
		
		//解析CIconfig.xml文件的任务节点
		ArrayList<String> CI_Task_pclint_list = analysis_CIconfig(CIconfig);
		
		//解析cicloud_task.xml文件的任务节点
		ArrayList<String> Actual_Task_pclint_list = analysis_cicloud_task(cicloud_task);
		
		//云构建任务与基线任务比较，增减更新任务节点
		Update_Node(CI_Task_pclint_list,Actual_Task_pclint_list,cicloud_task);
		
	}
	
	public static ArrayList<String> analysis_CIconfig(String CIconfig) {
		ArrayList<String> CI_Task_pclint_list = new ArrayList<String>();
		
		try {
			SAXReader reader = new SAXReader();
			File CIconfig_file = new File(CIconfig);
			Document document = reader.read(CIconfig_file);//加载xml文件，获取document对象
			Element root_node = document.getRootElement();//获取document对象根节点
			System.out.println("CIconfig.xml根节点名： " + root_node.getName());

			List<Element> OneLayer_NodesList = root_node.elements();//获取根节点下所有一层子节点列表
			for (Element OneLayer_SubNode : OneLayer_NodesList) {
				//System.out.println("一层子节点: " + OneLayer_SubNode.getName());
				String attr_value = OneLayer_SubNode.attributeValue("name");
				/*子节点调用attributeValue()方法，传入属性名参数，直接获得属性值*/
				CI_Task_pclint_list.add(attr_value);
				//System.out.println("基线文件pclint节点属性值: " + attr_value);
			}
			System.out.println("基线文件所有pclint节点: " + CI_Task_pclint_list);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CI_Task_pclint_list;
	}
	
	
	public static ArrayList<String> analysis_cicloud_task(String cicloud_task) {
		//List是一个接口类，不能构造对象；而ArrayList是一个类，可以创建对象
		ArrayList<String> Actual_Task_pclint_list = new ArrayList<String>();
		
		try {
			SAXReader reader = new SAXReader();
			File task_file = new File(cicloud_task);
			Document document = reader.read(task_file);//加载xml文件，获取document对象
			Element root_node = document.getRootElement();//获取document对象根节点
			System.out.println("cicloud_task根节点名" + root_node.getName());
			
			/*
			//备用：element()方法，获取某层节点下一层子节点；这里可以直接蹦到第2层级节点进行for循环
			Element sub_node = root_node.element("agenttask");
			System.out.println("得到一层子节点" + sub_node.getName());
			Element sub_sub_node = sub_node.element("task");
			System.out.println("得到单独二层子节点" + sub_sub_node.getName());
			List<Element> OneLayer_List = sub_node.elements();
			for (Element SubNode : OneLayer_List) {
				System.out.println("只能得到第一个agenttask下的子节点名： "+SubNode.getName());
			}
			*/
			
			List<Element> OneLayer_NodesList = root_node.elements();//获取根节点下所有一层子节点列表
			for (Element OneLayer_SubNode : OneLayer_NodesList) {
				//System.out.println("一层子节点: " + OneLayer_SubNode.getName());
				
				List<Element> TwoLayer_NodesList = OneLayer_SubNode.elements();//获取一层子节点下所有二层子节点列表
				for (Element TwoLayer_SubNode : TwoLayer_NodesList) {
					//System.out.println("二层子节点: " + TwoLayer_SubNode.getName());
					//根据指定的某个属性名，获取对应的属性值；这种方式适用于获取节点下部分属性信息
					String attr_value = TwoLayer_SubNode.attributeValue("node_task");
					//System.out.println("实际pclint节点属性值: " + attr_value);
					/*子节点调用attributeValue()方法，传入属性名参数，直接获得属性值*/
					Actual_Task_pclint_list.add(attr_value);
					
					/*
					//方法备用：下面这个for循环是获取某个节点下所有属性信息，适用于获取节点下全部属性信息
					List<Attribute> Attr_list = TwoLayer_SubNode.attributes();
					for (Attribute attr : Attr_list) {
						if (attr.getName() == "node_task") {
							Actual_Task_pclint_list.add(attr.getValue());
						}
					}
					*/
				}
			}
			System.out.println("实际所有pclint节点: " + Actual_Task_pclint_list);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Actual_Task_pclint_list;
	}
	
	public static void Update_Node(ArrayList<String> CI_Task_pclint_list,
			ArrayList<String> Actual_Task_pclint_list,String cicloud_task
			) {
		//DOM4J解析XML文件，被注释的节点不会解析出来
		for (String i : Actual_Task_pclint_list) {
			if (!CI_Task_pclint_list.contains(i)) {
				System.out.println("任务节点已经被删除"+i);
				
				
			}
		}
		
		
		
		//System.out.println("列表长度"+OneLayer_NodesList.size());
	}
	
	
}
