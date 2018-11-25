package Core_Java_Volumn_Ⅰ_Fundamentals.fourth_chapter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class fourth_chapter {
	
	 public static void start_fourth_chapter() {
		 
		 /**4.1 面向对象程序——简称OOP*/
		 /*关于类、对象、封装的概念，以及类和对象、类之间的关系，请看书中本章第一节，此代码文档直接进入示例讲解*/
		 /*1.实例域的概念是：对象中的数据就是实例域，狭义的理解就是对象中的变量；操纵实例域的过程称为方法；
		  *2.Java并不是所有类都具有面向对象的特征，意思是不必按照套路性的流程——首先根据类创建实例对象，然后对象调用类中的方法，
		  *	有些标准类可以直接调用本身的方法，例如Math类可以直接调用random()方法，double n1 = Math.random();
		  *	用户定义的一些类也可以不使用面向对象的特征，
		  *	例如本章的fourth_chapter类，在main函数中被引用，直接调用start_fourth_chapter()方法；*/

		 /**4.2使用现有类——即标准类库*/
		 //对象与对象变量
		 /*？后期要总结出以下结论：？
		   *1.标准类库什么样的情况下，可以直接用类调用自己的方法？
		   *2.标准类库中，什么样的类不能创建实例对象？*/
		 
		 /*Java绝大部分情况是都具有面向对象特征的；即要想使用对象，就首先用构造器构造新的实例对象，然后对实例施加方法；以Date类为例，如下：*/
		 /*1.构造器是类中的一种特殊方法，专用于构造对象，并且在类中构造器应该是public类型；
		  *2.上面问题出来一个待验证的答案：没构造器方法的类不能创建实例对象；*/
		 new Date();
		 System.out.println("Date类型的数据输出： " + new Date());
		 new Date().toString();
		 /*
		 try {
			Thread.sleep(5000);
			System.out.println("字符串Sting类型的日期时间输出： " + new Date().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
		 /*上面代码其实是创建了4个实例对象，从延时5秒执行就可以证明；剖析说明：
		  *1.构造器是Date()，构造器的名称是Date，与类名相同；在构造器前加上new关键字，就新创建了一个Date类型的对象；
		  *2.构造的对象可以作为参数传递个其他类中方法的形参，如System.out.println(new Date());
		  *3.构造的对象理所当然的能够调用Date类中的方法，如new Date().toString()*/
		 
		 Date time_1 = new Date();
		 Date time_2;
		 time_2 = time_1;
		 /*对象和对象变量 重要区别：
		  *1.构造的对象可以存放在一个变量中，即把构造的对象赋值给变量；对象变量跟普通变量一样，都是对值(值就是对象)的一种引用；
		  *2.如果创建了一个新的变量，也可以让这个变量引用其他一个已经引用了对象的变量，如time_2 = time_1;
		  *	 实际上，time_2和time_1引用的是同一个对象，从内存的堆栈关系就可以证明；*/
		 
		 //Java标准类库中的 GregorianCalendar类
		 /*根据类创建对象时能够向对象中传参，是因为类中有构造方法，并且有this关键字；类似于python中的__init__(self,var1,var2)；*/
		 /*Date类只能得到和保存当前时间点；GregorianCalendar除此之外，还能设定历史日期时间点，并且还可以只处理年月日；*/
		 GregorianCalendar Calendar_1 = new GregorianCalendar();
		 GregorianCalendar Calendar_2 = new GregorianCalendar(1991,10,10);
		 GregorianCalendar Calendar_3 = new GregorianCalendar(1991,Calendar.DECEMBER,31);
		 /*1.构造对象时如果不加参数，得到的时间就是当前时间；如果加入传参，得到时间是设定的历史时间；
		  *2.如果传参的月份用int型数值表示，转换成Date类型输出并不能直接得到设定的的月份；因为月份从0开始计数，所以10表示十一月november；
		  *3.如果想要直接得到设定月份，需要调用Calendar类的常量，如Calendar.DECEMBER；类常量(即类属性)，可直接用类名访问；*/
		 
		 Date Calendar_1_value = Calendar_1.getTime();
		 Date Calendar_2_value = Calendar_2.getTime();
		 Date Calendar_3_value = Calendar_3.getTime();
		 /*getTime()方法是GregorianCalendar类中的方法，获得对象中的时间点，并且转换为Date类型的数据；*/
		 
		 Calendar_1.setTime(Calendar_2_value);
		 int new_year = Calendar_1.get(Calendar.YEAR);
		 /*setTime()方法，设置日历对象表示的时间点；setTime()是void类型，没有返回值；
		  *这个方法的作用是：获取其他对象的时间，设定给新的GregorianCalendar类对象时间；*/
		 
		 System.out.println("当前时间： 				" + Calendar_1_value);
		 System.out.println("利用int型得到历史时间： 		" + Calendar_2_value);
		 System.out.println("利用Calendar常量得到历史时间： 	" + Calendar_3_value);

		 //访问器方法和更改器方法
		 System.out.println(Calendar_1);//打印输出对象，并不是直接得到时间点
		 int now_1 = Calendar_1.get(Calendar.MONTH);
		 int now_2 = Calendar_1.get(Calendar.DAY_OF_WEEK);
		 Calendar_2.set(Calendar.YEAR, 2001);//1991年变成2001年
		 Calendar_2.set(Calendar.MONTH, Calendar.SEPTEMBER);//11月变成12月
		 Calendar_2.add(Calendar.YEAR, 2);//add()方法是GregorianCalendar类中的方法；2001年加2年；
		 /*1.上面说过，传参是int型数值的月份，输出时加1；相反，传参是Calendar类常量，输出时则减1；
		  *2.get()方法、set()方法是Calendar类中的方法，由于GregorianCalendar类是Calendar类的扩展类，所以可以调用；
		  *3.get()方法必须加参数，得到年月日其中部分或全部信息；getTime()是获取全部时间点信息*/
		 System.out.println("得到月份是： " + now_1);
		 System.out.println("得到一周的第几天： " + now_2);
		 
		 /**4.3用户自定义类*/
		 //Java关于自定义类的规定：
		 /*1.每个Java文件只能有一个公有类 public class，可以有若干的非共有类class
		  *2.
		  * */
		 class employee {
			 
			 
		 }
		 
	}

}