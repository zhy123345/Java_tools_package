package read_write_xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.io.XMLWriter;

import com.sun.beans.decoder.DocumentHandler;

public class Main {
	
	public static void main(String[] args) throws IOException {
		//String new_sync_dir = args[0];
		String new_sync_dir = ";q/x";
		//String Ciconfig = args[1];
		//String task = args[2];
		String CIconfig = "CIconfig.xml";
		String cicloud_task = "cicloud_task.xml";
		
		//解析CIconfig.xml文件的任务节点
		ArrayList<String> CI_Task_pclint_list = analysis_CIconfig(CIconfig);
		
		//解析cicloud_task.xml文件的任务节点
		ArrayList<String> Actual_Task_pclint_list = analysis_cicloud_task(cicloud_task);
		
		//删除不存在的任务节点
		ArrayList<String> Require_NodeList = Delete_Node(CI_Task_pclint_list,Actual_Task_pclint_list,cicloud_task);
		
		//增加新的任务节点
		Add_Node(cicloud_task,Require_NodeList);
		
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
			System.out.println("cicloud_task根节点名： " + root_node.getName());
			
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
			
			Element agentTasks_SubNode = root_node.element("agentTasks");
			List<Element> agentTask_NodeList = agentTasks_SubNode.elements();//获取根节点下所有一层子节点列表
			for (Element agentTask_SubNode : agentTask_NodeList) {
				//System.out.println("一层子节点: " + OneLayer_SubNode.getName());
				
				List<Element> task_NodeList = agentTask_SubNode.elements();//获取一层子节点下所有二层子节点列表
				for (Element task_SubNode : task_NodeList) {
					//System.out.println("二层子节点: " + TwoLayer_SubNode.getName());
					//根据指定的某个属性名，获取对应的属性值；这种方式适用于获取节点下部分属性信息
					/*子节点调用attributeValue()方法，传入属性名参数，直接获得属性值*/
					
					String plugin_AttrValue = task_SubNode.attributeValue("plugin");
					String name_AttrValue = task_SubNode.attributeValue("name");
					if (plugin_AttrValue.equals("pclint")) {
						Actual_Task_pclint_list.add(name_AttrValue);
					}
					
					/*
					方法备用：下面这个for循环是获取某个节点下所有属性信息，适用于获取节点下全部属性信息
					List<Attribute> all_attr_list = task_SubNode.attributes();
					for (Attribute attr : all_attr_list) {
						if (attr.getName().equals("node_task")) {
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
	
	public static ArrayList<String> Delete_Node(ArrayList<String> CI_Task_pclint_list,
			ArrayList<String> Actual_Task_pclint_list,String cicloud_task
			) throws IOException {
		
		//DOM4J解析XML文件，被注释的节点不会解析出来
		ArrayList<String> Delete_NodeList = new ArrayList<String>();
		for (String task_name : Actual_Task_pclint_list) {
			if (!CI_Task_pclint_list.contains(task_name)) {
				Delete_NodeList.add(task_name);
			}
		}
		System.out.println("已经被删除任务节点列表： " + Delete_NodeList);
		Actual_Task_pclint_list.removeAll(Delete_NodeList);
		ArrayList<String> Available_NodeList = new ArrayList<String> (Actual_Task_pclint_list);
		
		CI_Task_pclint_list.removeAll(Available_NodeList);
		ArrayList<String> Require_NodeList = new ArrayList<String> (CI_Task_pclint_list);
		
		try {
			SAXReader reader = new SAXReader();
			File task_file = new File(cicloud_task);
			Document document = reader.read(task_file);//加载xml文件，获取document对象
			Element root_node = document.getRootElement();//获取document对象根节点
			System.out.println("cicloud_task根节点名： " + root_node.getName());
			//以上代码单独放在一个方法，减少重复性
			
			Element agentTasks_SubNode = root_node.element("agentTasks");
			List<Element> agentTask_NodeList = agentTasks_SubNode.elements();//获取根节点下所有一层子节点列表
			for (Element agentTask_SubNode : agentTask_NodeList) {
				
				List<Element> task_NodeList = agentTask_SubNode.elements();//获取一层子节点下所有二层子节点列表
				for (Element task_SubNode : task_NodeList)  {
					String name_AttrValue = task_SubNode.attributeValue("name");
						if (Delete_NodeList.contains(name_AttrValue)) {
							System.out.println("任务被删除： " + name_AttrValue);//这只是在内存中删除，需要写回原文件
							
							//删除task级别的节点
							task_SubNode.getParent().remove(task_SubNode);
							OutputFormat format = OutputFormat.createPrettyPrint();
							format.setEncoding("UTF-8");
							XMLWriter writer = new XMLWriter(new FileWriter
									(new File("cicloud_task.xml")), format);
							//XMLWriter writer = new XMLWriter(new OutputStreamWriter
								//	(new FileOutputStream("cicloud_task.xml")), format);
							writer.write(document);
							writer.close();
						}
					}
				}
				
				//删除agenttask级别的大节点，判断依据是内层节点数为0
				for (Element agentTask_SubNode : agentTask_NodeList) {
					List<Element> task_NodeList = agentTask_SubNode.elements();
					if (task_NodeList.size()==0) {
						agentTask_SubNode.getParent().remove(agentTask_SubNode);
						OutputFormat format = OutputFormat.createPrettyPrint();
						format.setEncoding("UTF-8");
						XMLWriter writer = new XMLWriter(new FileWriter
								(new File("cicloud_task.xml")), format);
						writer.write(document);
						writer.close();
					}
				}
				
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Require_NodeList;
	}
	
	public static void Add_Node(String cicloud_task, ArrayList<String> Require_NodeList) throws IOException {
		
		try {
			SAXReader reader = new SAXReader();
			File task_file = new File(cicloud_task);
			Document document = reader.read(task_file);
			Element root_node = document.getRootElement();
			System.out.println("cicloud_task：：：：：根节点名： " + root_node.getName());
			
			Element agentTasks_SubNode = root_node.element("agentTasks");
			List<Element> agentTask_NodeList = agentTasks_SubNode.elements();
			
			//得到新增节点的插入位置
			//实现目的，每3个小节点存储在一个agenttask大节点中
			int i = 0;
			for (Element agentTask_SubNode : agentTask_NodeList) {
				String bigtask_AttrValue = agentTask_SubNode.attributeValue("bigtask"); 
				if (bigtask_AttrValue.startsWith("code") 
						|| bigtask_AttrValue.startsWith("res") 
						|| bigtask_AttrValue.startsWith("pclint")) {
					i++;
				}
			}
			
			Element new_agentTask_SubNode = DocumentHelper.createElement("agentTask");//这里只是创建节点元素，并没有添加到xml中，因为后面要指定添加位置
			new_agentTask_SubNode.addAttribute("bigtask", "pclint_4");
			new_agentTask_SubNode.addAttribute("rsyncdir", "V8R6C00/");//插入节点属性时，多个属性直接会自动用空格间隔
			agentTask_NodeList.add(i,new_agentTask_SubNode);
			
			for (String Require_Node : Require_NodeList) {
			Element task_node = new_agentTask_SubNode.addElement("task");
			task_node.addAttribute("plugin", "pclint");
			task_node.addAttribute("name", Require_Node);
			task_node.addAttribute("module", Require_Node);
			}
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			//format.setNewlines(true);//设置换行
			//format.setIndent(true);
			//format.setIndent("	");//设置缩进且缩进为一个tab字符
			//format.setLineSeparator("\n");
			//format.setTrimText(true);
			

			
			XMLWriter writer = new XMLWriter(new FileWriter
					(new File("cicloud_task.xml")), format);
			writer.write(document);
			writer.close();
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void change_attr(String cicloud_task, String new_sync_dir) {

		try {
			SAXReader reader = new SAXReader();
			File task_file = new File(cicloud_task);
			Document document = reader.read(task_file);
			Element root_node = document.getRootElement();
			System.out.println("cicloud_task根节点名" + root_node.getName());
			List<Element> OneLayer_NodesList = root_node.elements();
			for (Element OneLayer_SubNode : OneLayer_NodesList) {
				String attr_value = OneLayer_SubNode.attributeValue("dir");
				Attribute attr = OneLayer_SubNode.attribute("dir");
				attr.setValue(attr_value + attr.getValue());
				System.out.println("同步目录: " + attr.getValue());

			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
