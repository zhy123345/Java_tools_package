package Core_Java_Volumn_one_Fundamentals.Main_book;
import java.util.ArrayList;
import Core_Java_Volumn_one_Fundamentals.fourth_chapter.fourth_chapter;
import Core_Java_Volumn_one_Fundamentals.knowledge_point.knowledge_static_modifier_usage;
import Core_Java_Volumn_one_Fundamentals.knowledge_point.knowledge_this_usage;
import java.lang.String;
public class Main_book {	//一个Java文件只能有一个public类，非public类可以有多个
	public final static String final_1="haha";
	/*final关键字定义常量，表示final_1只能被赋值一次，类的常量定义在方法外部；static表示静态域；*/
	//final_1 = "hhhh";//已经定义好的常量final_1不能更改值，如果再被赋值就会报错
	
	/*一个项目中允许有多个main方法，可以定义哪个为首要的main；且main方法必须声明为public*/
	public static void main(String[] args) {	//数组作为main方法的传参，就是在运行Java xxx.java命令时，需要传入的参数；
		//args = new String[1];
		//args[0] = "wer";
		/*1.方法的入参用()括号括起来，多个参数之间要用逗号隔开(而不是像条件、循环语句中用分号隔开)；并且最后一个参数后面不加任何符号
		 *2.这里入参是数组args，在方法的入参中只声明了数组变量及类型，并没有创建数组对象(即没有初始化数组对象)；
		 *3.args数组的长度，只有在命令行运行程序时传入参数才能确定；即传入多少个参数，长度就确定为多少
		*/
		
		System.out.println(final_1);//使用常量只能在方法内使用，例如打印输出；

		/**  第三章   */
		/*
		third_chapter use_third_chapter = new third_chapter(); 
		String third_content = use_third_chapter.start_third_chapter();
		System.out.println(third_content);
		*/
		
		/**  第四章   */
		/*
		fourth_chapter.start_fourth_chapter();//这是因为start_fourth_chapter()是静态方法，因此方法可以直接被所属类调用，而不必创建对象实例化，当然也可以创建对象再调用方法
		*/

		/**	 static 修饰符(modifier) 用法  */
		/*
		int i = knowledge_static_modifier_usage.i;
		System.out.println(i);

		knowledge_static_modifier_usage kn = new knowledge_static_modifier_usage();
		int j = kn.j;
		System.out.println(j);

		int ii = knowledge_static_modifier_usage.getNumber();
		System.out.println(ii);
		int jj = kn.getDealNumber(10);
		System.out.println(jj);
		*/


		/**	 this 的用法  */
		knowledge_this_usage kn = new knowledge_this_usage(100);
		kn.increament().print();

	}
	
	public static void aa() {
		ArrayList<String> Test = new ArrayList<String>();
		Test.add("dd");
		Test.add("eee");
		Test.get(1);
	}

	//提前介绍一下什么叫实现接口，所谓实现接口的概念就是：接口就是声明了方法而不去实现，留给某个类去实现这个接口的方法
	
}
