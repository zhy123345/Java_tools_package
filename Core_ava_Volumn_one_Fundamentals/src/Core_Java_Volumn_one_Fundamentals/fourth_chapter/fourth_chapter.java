package Core_Java_Volumn_one_Fundamentals.fourth_chapter;
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
		 /*1.Java关于自定义类的规定：每个Java文件只能有一个公有类 public class，可以有若干的非共有类class；
		  *2.Java一个完整的程序项目是由若干类组合在一起，只有一个main方法*/
		 
		 //4.3.1下面是关于用户自定义类的例子，非常重要经典，里面牵扯到很多语法概念；详情分析见示例后面
		 Employee staff_obj = new Employee("carl",75000,1987,12,15);//此行代码不参与运行下面示例
		 /*这行代码只为说明根据类创建对象时，可以通过自定义类中的构造方法Employee()，初始化对象属性(即对象的变量)；
		  *类似于python中面向对象的__init__方法，在创建对象时就可以直接传入实参；
		 *注意：python中的构造函数__init__()主要是用来初始化实例对象的属性(即变量)，即便没有构造函数也能创建对象*/
		 Employee[] staff = new Employee[3];
		 /*创建一个数组对象变量，数据元素类型是自定义的Employee类型*/
		 staff[0] = new Employee("carl",75000,1987,12,15);
		 staff[1] = new Employee("harry",50000,1989,10,1);
		 staff[2] = new Employee("tony",40000,1990,3,15);
		 
		 for (Employee e : staff) {
			 e.raiseSalary(5);
		 }
		 
		 for (Employee e : staff) {
			 System.out.println(
					 "name=" + e.getName()+
					 ",salary=" + e.getSalary()+
					 ",hireDay=" + e.getHireday());
		 }
	 }
}

class Employee {//非共有类Employee和共有类fourth_chapter类是平级
	//定义类的私有属性(即对象的实例域)
	private String name;
	private double salary;
	private Date hireday;
	
	public Employee(String n, double s, int year, int month, int day) {
		/*Employee()是构造方法，Java规定要和类名相同，并且可以不加void修饰符；作用是初始化类属性的值*/
		/**构造方法很重要，重点掌握**/
		
		name = n;//也可以this.name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		hireday = calendar.getTime();
	}
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public Date getHireday() {
		return hireday;
	}
			 
	public void raiseSalary(double byPersent) {
		double raise = salary * byPersent / 100;
		salary +=raise;
	}
}
//关于上面自定类示例的详细分析和说明

//4.3.2多个源文件——以及编译
/*1.在本源文件中包含了两个类fourth_chapter和Employee；也可以把每个类存放在一个单独的源文件中，即Employee在Employee.java文件中；
 *2.编译时可使用命令 javac fourth_chapter.java；虽然没有Employee.java源码文件，但是编译时把Employee类独立的编译成了
 *  Employee.class*/

//4.3.3分析Employee类
/*1.此类共包含一个构造器方法和4个方法；分别是：Employee(),getName(),getSalary(),getHireday()和raiseSalary();
 *2.所有方法都使用了关键字public，意味着其他任何类的任何方法都可以调用这些方法；
 *3.**重点：Employee类的实例中(注意是实例中)有3个实例域，用来存放要操作的数据；注意：因为要根据Employee类创建实例对象，
    *而对象最终要通过Employee类中方法访问这些实例域，所以从实例域的概念上理解，实例域是对象中的数据，而不是类的实例域；
 *4.private关键字能确保只有Employee类自身的方法才能访问这些实例域，其他类的方法不能直接访问这些实例域；
 *5.下面描述一下其他类的方法是如何访问实例域的，以private String name为例：
 *	1)首先，Employee类中为对象定义了私有实例域；并且fourth_chapter类中创建一个staff[0]对象，对象中带有传入的实参；
 *	2)然后，这些实参通过构造器方法中的name = n;，赋值给实例域；
 *	3)最后，这些被赋值的实例域通过getName()方法，返回给staff[0]对象；
 *	**所谓不能直接访问实例域，就是说对象不能直接得到返回值；
 *	因此，Employee类实现了对实例域值的保护；封装的目的是为了防止其他类的方法修改对象的实例域值，并不是防止篡改实例域名！！！***/

//4.3.6封装的优点
/*1.getName(),getSalary(),getHireday()方法，只返回实例域的值；称为访问器方法
 *2.关键在于name，是只读域，在构造器中设置完成后，就可以防止外界类的方法改变实例域值；
 *3.虽然salary不是只读域，但是只有Employee类中方法raiseSalary()才可以修改其值，如果此域值出错，只需调试raiseSalary()方法即可；
 *	如果salary域是public公有的实例域，那么任何方法都可以破坏域值；
 *4.对于实例域hireday，违反了一个原则：返回了一个可变对象的引用；导致结果是：虽然为私有的实例域，但是仍会被破坏封装性，详情参考本书；
 *5.综上，使用private标记实例域，比定义一个简单的public公有域复杂，但是优点是：
 *	1)可以改变内部实现，除了改类的方法外，不会影响其他代码
 *	2)更改器方法(如常用的set**)可以执行错误检查，而直接对域进行赋值，不会进行这些处理*/

//4.3.4构造器——public Employee(String n, double s, int year, int month, int day)
/*1.构造器是一种特殊的方法，必须与类名同名；在创建Employee类的对象时，构造器被运行，并将实例域初始化为所希望的值；
 *2.构造器伴随着new关键字的执行而被调用；不能用对象调用构造器方法，例如下面是错误的：
 *	staff[0].Employee("carl",75000,1987,12,15);
 *3.构造器方法的特点：
 *	构造器与类同名
 *	每个类可以有多个构造器
 *	构造器可以有多个参数
 *	构造器没有返回值
 *	new关键字的操作会调用构造器方法
 *4.注意：不要在构造器中定义与实例域重名的局部变量，如下是错误的：
 *	public Employee(String n, double s, int year, int month, int day) {
 *		String name = n;//由于重新声明了name的数据类型，所以这里实际的效果是声明了一个新的变量，与private String name重名了;
 *	}*/

//4.3.5隐式参数与显式参数



/**4.4静态域和静态方法——无论是静态域还是静态常量，都属于类变量和类常量的范围*/
//4.4.1静态域——静态域被称为类域
/*首先明白静态域的概念：是指加了static关键字的实例域，即类中定义的加了static的变量，但是实例域并无实际意义；
    注意：但是在方法中的局部变量或常量，不能加关键字public private static修饰；*/

//4.4.2静态常量
/*1.静态域(暂理解为静态变量)使用的比较少，但是静态变量使用的比较多；
  2.例如Java的标准类库中的Math类定义了一个常量：
  public class Math
  {
 	...
 	public static final double PI = 3.1415926;
 	...
  }*/

/*2.很重要****：任何类的静态常量，都需要 用类名.常量名 的方式获取常量；
  3.如果static关键字被省略，则PI就成了Math类的一个实例域，而实例域是需要创建Math类的对象后，通过对象访问的实例域的(实际Math类无构造函数)；
  4.由于每个类的对象都可以对公有域进行修改，所以最后不要将域设计为public；
	然而公有常量(即public final域)却没有问题；*/

//4.4.3静态方法
//main函数必须以public和static关键字修饰
//而Java中构造器主要是用来创建对象并初始化，如果没有构造器，连对象都不能创建
//Java的实例域就是指对象中的数据变量，注意不是类中的，上面示例中虽然定义了三个类属性变量，但是如果没有创建对象，就不能说是实例域




