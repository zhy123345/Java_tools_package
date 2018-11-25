package Core_Java_Volumn_Ⅰ_Fundamentals.Main_book;
import Core_Java_Volumn_Ⅰ_Fundamentals.fourth_chapter.fourth_chapter;

public class Main_book {
	public final static String final_1="haha";
	/*final关键字定义常量，表示final_1只能被赋值一次，类的常量定义在方法外部；一般要加static关键字*/
	//final_1 = "hhhh";//已经定义好的常量final_1不能更改值，如果再被赋值就会报错
	
	/*一个项目中允许有多个main方法，可以定义哪个为首要的main；且main方法必须声明为public*/
	public static void main(String[] args) {//数组作为main方法的传参；
		//args = new String[1];
		//args[0] = "wer";
		/*1.方法的入参用()括号括起来，多个参数之间要用逗号隔开(而不是像条件、循环语句中用分号隔开)；并且最后一个参数后面不加任何符号
		 *2.这里入参是数组args，在方法的入参中只声明了数组变量，并没有创建数组对象(即没有初始化数组对象)；
		 *3.args数组的长度，只有在命令行运行程序时传入参数才能确定；即传入多少个参数，长度就确定为多少*/
		
		System.out.println(final_1);//使用常量只能在方法内使用，例如打印输出；

		/**  第三章   */
		/*
		third_chapter use_third_chapter = new third_chapter(); 
		String third_content = use_third_chapter.start_third_chapter();
		System.out.println(third_content);
		*/
		
		/**  第四章   */
		fourth_chapter.start_fourth_chapter();//这是因为Java类并不是都具有面向对象特征，所以可直接调用类中的方法
		
	}
	
}
