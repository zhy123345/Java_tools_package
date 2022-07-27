package Core_Java_Volumn_one_Fundamentals.third_chapter;//在Java中，菜鸟第一步首先要声明包名，Java的程序结构是：src目录为包名目录的集合
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.System;//使用的类在基本java.lang包中，可以不用import导入，即Java会默认导入
import java.math.BigInteger;

/*Java项目结构中，含有一个src包集合，src下可包含多个包(包就是文件夹)，
 *创建项目时默认包名为项目名；包下面才是Java文件，创建Java文件时其实是创建一个类
*/
//import Core_Java_Volumn_Ⅰ_Fundamentals.java_base.base;//注意，如果Java文件中导入类模块，一定要是在声明包名语句之后导入
public class third_chapter {

	public static String start_third_chapter() {

	/***3.6节——字符串***/
	//子串
	/*首先要知道Java共有8种基本数据类型(注意是基本类型共有8种)，其中的char是字符类型(不是字符串)，但是除了基本类型外还有很多种其他类型数据；
	 *Java是强类型语言，在声明变量时必须指定变量类型；声明这8种基本类型的变量时，是使用关键字char、int等，而不是用String等其他数据类型的类名；
	 *这8种数据类型是Java的内置的；
	 *
	 *Java字符串类型就是由标准类库中的预定义类String提供的，Java没有内置的字符串类型；
	 *Java声明任何标准类库中类型的变量时，本质是根据类创建了一个对象；如String greeting = "Hello"；
	 *其中Hello就是String类的一个实例，其实任何用双引号括起来的字符串都是String类的一个实例对象；
	 *如下：使用关键字new 也是Java根据类创建实例对象的一种常用方式
	 */
		String new_obj = new String("ss");
		
		String greeting = "";//打印空的字符串能导致输出结果为空行
		System.out.println(greeting);//Java中调用方法时，打印得到的结果，其实也是方法的return返回值？？
		greeting = "old";
		greeting = "Hello";//重新赋值同名变量时，不能再声明变量名类型；
		
		/*
		 ******Java中如果使用了根据某个类的定义了变量或者创建了实例对象，那么这个变量不能使用其他类中的方法******；
		 ******注意：Java不能'直接'修改字符串******；首先注意，这里说的是不能直接修改字符串，而不是不能直接修改变量值；
		 *这和Java的String是不可变类有关，Java在定义字符串变量时，把所有赋值过的字符串存储在一个常量池中，常量池和内存的堆栈有关，
		 *变量值改变后，变量greeting指向(通过内存地址)内存堆区中的新建的Hello对象，原来old字符串对象并没给没更改；这叫做不能直接修改字符串；
		 *具体详情参考链接：https://zhidao.baidu.com/question/253995346.html
		 */
		/*上面所说不能直接修改字符串对象，但是可以使用substring()方法间接修改，修改后常量池中就没有了Hello，如下：
		 *greeting = greeting.substring(0,3)";
		 *System.out.println(greeting);
		 *String类中的substring()方法，从字符串中提取子串，以索引位指定字符位置范围；greeting的值为Hel!
		 */
		
		//判断两个字符串是否相等，使用equals()方法；相等则返回布尔值true，不相等则返回布尔值false；与shell脚本相反，shell使用==判断；
		/*Java判断两个数值类型的数据是否相等和不等，使用== 和！=；
		 */
		String test1 = "ok";
		test1.equals(greeting);
		boolean aa = "Hello".equals(greeting);
		System.out.println(aa);
		
		//代码点和代码单元的理解；这里涉及到字符集编码的内容，不做过深研究
		/*Java采用unicode—16字符集编码，即用16位二进制表示一个字符(一个字符可以是键盘上的字母、数字、标点，或者其他符号)
		 *而2个十六进制表示位8位二进制，所以Java是2个十六进制表示一个字符；
		 *在Java中所谓代码单元，就是用来表示一个字符的16位二进制；代码点就是unicode字符集编码表中某个字符对应的编号(即代码值)
		 *具体参考以下链接:
		 *https://zhidao.baidu.com/question/74466416.html
		 *https://blog.csdn.net/u010411264/article/details/45258629
		 *https://blog.csdn.net/u014028027/article/details/78180827
		 *https://www.cnblogs.com/benbenalin/p/6921553.html
		 *总结，无论是哪种字符集编码，最终都要转换成二进制供计算机识别
		 */
		int n = greeting.length();
		System.out.println("length()方法——得到代码单元数量 "+n);
		int count = greeting.codePointCount(0, n);
		System.out.println("codePointCount()方法——获取代码点数量，即实际长度 "+count);
		char point = greeting.charAt(0);
		System.out.println("charAt()方法——得到某个索引位的代码单元对应的字符 "+point);
		int number = greeting.codePointAt(0);
		System.out.println("codePointAt()方法——得到某个索引位的代码点 "+number);
		
		//构建字符串
		/*String类用+拼接字符串的方式效率低，每次连接字符串时都会产生一个新的String对象，既耗时又浪费内存空间，
		 *所以一般使用StringBuilder类 构建字符串就可以优化上面问题，因为StringBuilder类是采用修改字符串方式；如下：
		 *stringbuilder类字符串和string类字符串区别https://www.cnblogs.com/mrxy/p/8057657.html
		 */
		StringBuilder builder = new StringBuilder("start:");//StringBuilder()构造一个空的字符串构建器，builder为空字符串
		builder.append("[submodule ");//StringBuilder类的append()方法，把多个小段字符串添加到构建器中，构建一个新的字符串
		builder.append("\"");
		builder.append(test1);
		System.out.println("验证 "+builder);//这里builder是StringBuilder类型字符串
		String chara = builder.toString();//StringBuilder类的toString()方法，把构建器中的字符串转化为String类型字符串
		System.out.println("写入文件第一行"+chara);
		
		
		/***3.7节——输入输出***/
		//读取输入
		/*读取输入需要用到Scanner类和System类；
		 *首先要使用Scanner()类构造一个Scanner对象，然后与标准输入流 System.in关联
		Scanner input = new Scanner(System.in);
//		System.out.println(input);
		String name1 = input.nextLine();//Scanner对象(即input)调用nextLine()方法，接受用户输入的字符串，字符串可以包含空白符
		System.out.println(name1);
		String name2 = input.next();//next()方法，接受用户输入的字符串时，遇到空白符会自动舍弃空白符后面的字符串
		System.out.println(name2);
		int age = input.nextInt();//nextInt()方法，接受用户输入的整数
		System.out.println(age);
		float numbers = input.nextFloat();//nextFloat()方法，接受用户输入的浮点数
		System.out.println(numbers);
		*/

		//关于读取密码的隐藏输入，后面再研究
//		Console ininput = System.console();//书上说不能直接输入，好像要他妈的存放在数组中，一会再说吧
//		String username = ininput.readLine("user name: ");
//		char[] passwd = ininput.readPassword("pass wd: ");
//		System.out.println(username);
//		System.out.println(passwd);
		
		//格式化输出——Java格式化输出也称占位符
		/*——System类在基本的java.lang包中；普通输出用print()或者println()方法，格式化输出必须用printf()方法；
		 *格式化都是以%为格式说明符的，格式说明符尾部的转换符用来表示要被格式化成哪种数值类型：f表示浮点数，s表示字符串，d表示十进制整数；
		 *关于转换符，有针对数值类型的，有针对字符串类型的，还有针对时间类型的；
		 *printf()和print()方法一样，都不能换行输出，所以输出对象要手动加换行符\n;
		 */
		double quotient = 10000 / 3.0;
		System.out.printf("%8.2f\n", quotient);//打印结果占8个字符的宽度，精确到小数点后2位；其中1个字符是输出结果前面的空格
		System.out.printf("Hello, %s Next year, you'll be %d\n","andi",24);
		String message = String.format("\nHello, %s Next year, you'll be %d","andi",24);
		System.out.println(message);//format()方法，创建一个格式化的字符串，即创建一个对象；不创建对象，上行代码也能打印
		
		//时间的格式化输出——首先明确Java对于时间的操作都在 Date()类中
		/*时间的普通格式化输出，在格式说明符%后都要加t，然后再加转换符
		 */
		Date shijian = new Date();
		System.out.println("原始的时间格式 "+shijian);
		System.out.printf("完整的时间格式 "+"%tc\n",shijian);
		/*时间被格式化的参数索引——由于某些时间格式化的转换符只能格式化时间的一部分(如年、月、日)，所以配合使用参数索引一次性格式化完整时间；
		 *如下，索引紧跟在说明符%后面，并以$结束，其含义是，1表示第一个被格式化的对象，2表示第二个格式化的对象(即时间)；
		 *如果只有一个时间对象要被格式化，那么索引参数只有1即可；
		 */
		System.out.printf("%1$s %2$tB %2$te, %2$tY\n","Due date:",shijian);
		System.out.printf("%1$tB %1$te, %1$tY\n",shijian);//跟上一行代码对比，就知道%后的索引位是什么意思了
		 
		//文件的输入与输出
		/*对文件读取，仍需要用Scanner类构造一个Scanner对象，然后再用File类构造的文件对象关联；注意以下几点：
		 *1、读取文件时可能会找不到文件，所以在定义方法时用throws FileNotFoundException或者在构造Scanner对象时用try—catch处理异常；
		 *2、文件的默认相对位置是Java虚拟机启动路径的相对位置(即命令解释器的当前路径)；如果使用IDE，则由开发环境控制，eclipse则把文件的
		 *相对路径设为项目文件夹的根目录下，即与src和bin目录平级的位置，可使用String dir = System.getProperty("user.dir");
		 *找到文件的相对路径
		 *3、File类可以构造文件对象，也可把一个字符串类型的文件名，转换为File类型的文件
		 */
		System.out.println(System.getProperty("user.dir"));
		File fileobj_1 = new File("one_file.txt");
		try {
			Scanner read_file = new Scanner(fileobj_1);
			System.out.println("不是打印文件内容 "+read_file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//写入文件
		/*写入文件需要构造一个PrintWriter对象，如果文件不存在，则会创建此文件；
		 *PrintWriter构造文件对象需要用异常处理的原因：可能是不能被创建的文件名——例如文件名不能有&符号
		 */
		try {
			PrintWriter out_file = new PrintWriter("one_test_file.txt");
			System.out.println("文件在内存的位置 "+out_file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**3.8节——控制流程，即条件判断语句和循环语句*/
		//块作用域——下面介绍块的概念
		/*"块"——即复合语句；在Java中狭义的讲，是由一对花括号括起来的若干条Java代码，甚至Java定义方法时花括号的代码语句，也都是块；
		 *块是一个很广义的概念，编程语言中任何一组属于某个归属的代码语句，都可称之为块；例如python中的函数体，就是属于函数的块语句；
		 *无论哪种语言，循环语句和判断语句都用到块；例如shell或者python的for语句的代码，就是属于for语句的块；
		 *块的作用之一就是确定了变量作用域(variable scope)，即在块中定义的变量只能在在本块中使用，不能在其他块中使用；
		 *但是因为一个块可以嵌套在另一个块中，所以内层块可以使用外层块的变量，反之则不可以；嵌套关系的两个块中，不能声明同名变量；
		 */
		String var_out = "waiceng  ";
//		int var_out_num = 2;//内外层块声明了同名变量，则报错
		{
			String var_in = "neiceng";
			int var_out_num = 6;
			System.out.println(var_in);
			System.out.println(var_out + var_out_num);
		}
//		System.out.println(var_in);//外层块引用了内层块声明的变量，则报错
		
		//if...else if...else 语句——格式如下：
		/*if (condition) {
		 *	statement1;
		 *	statement2;
		 * }
		 *else if {
		 *	statement3;
		 *	statement4;
		 * }
		 *else {
		 *	statement5;
		 * }
		 *Java中没有elif，而是拆写成的else if，也就是说Java都是多if...else语句；若是条件语句和{}中的块在一行，就不用写{}了，见原书；
		 */
		
		//while 循环判断语句——格式如下：
		/*while (condition) {
		 *	statement1;
		 *	statement2;
		 * }
		 *这是while语句最一般的用法，但如果循环条件开始就不成立，那么循环体(块)中的所有代码不会执行；
		 *如果希望while块中代码至少执行一次，则使用do/while循环语句，稍后讲解；while一般用法如下例：
		 */
		double goal_1 = 9999999.88;
		System.out.println("退休时资产目标： " + goal_1);
		double payment_1 = 999999.88;
		System.out.println("每年最低收入：" + payment_1);
		double interestrate_1 = 1.7;
		System.out.println("每年最低年利率：" + interestrate_1);
		
		double balance_1 = 0;
		int years_1 = 0;
		//开始更新每年财务平衡
		while (balance_1 < goal_1) {
			balance_1 += payment_1;
			double interest_1 = balance_1 * interestrate_1 / 100;
			balance_1 += interest_1;
			years_1++;
		}
		System.out.println("他妈的累这么多年之后才能有充足的保障退休： " + years_1);
		/*1.years_1变量虽然在while内层块被加工处理过，但是仍是外层块声明的变量，所以最后一句代码可以使用years_1；
		 *2.正如前面所讲，如果while语句的条件判断不成立，while块的代码不执行；如果希望至少执行一次，则使用do/while语句，如下：
		 
		Scanner in_while = new Scanner(System.in);
		
		double payment_2 = 999999.88;
		System.out.println("每年最低收入：" + payment_2);
		double interestrate_2 = 1.7;
		System.out.println("每年最低年利率：" + interestrate_2);
		
		double balance_2 = 0;
		int years_2 = 0;
		String input_determine;
		do {
			balance_2 += payment_2;
			double interest_2 = balance_2 * interestrate_2 / 100;
			balance_2 += interest_2;
			years_2++;
			System.out.printf("\nafter year %d,your balance is %.2f\n", years_2,balance_2);
			System.out.println("Ready to resire? (Y/N)");
			input_determine = in_while.next();
		}
		while (input_determine.equals("N"));
		*/
		/*判断while条件是否成立之前，do代码块中语句已经执行了一次；while语句条件判断如果成立，则do代码块继续执行；否则，停止循环*/
		 
		
		//确定循环——for循环语句，for循环就是while判断循环的简化形式；for循环常用结构有两种：
		/*第一种是经典的迭代方式*/
		//int i;
		for (int i=1; i<=4; i++) {
			System.out.println(i);
		}
		
		/*第二种是遍历元素的方式，即类似于for j in 形式；即在本书后面讲的for each循环*/
		/*for each循环定义了一个暂存集合中每个元素的变量，用于遍历集合中元素；集合可以是后面讲的数组，数组列表，字典或者其他类型的元素集合*/
		String[] strlist = {"\na","b","c","d"};
		for (String j : strlist) {
			System.out.println(j);
		}
		/*无论哪种方式，都是在for语句的括号()内声明的变量；当然，第一种方式可以在for语句之前先声明变量i；
		 * 在for语句括号()内声明的变量，只能在for块内使用(即局部变量)，for语句之前声明的变量，在方法内任何位置都可使用 
		*/
		
		//switch语句——类似于shell的case语句
		/*switch语句类似于shell的case语句，也是if-else语句的高级技巧用法，**但是Java中几乎不用**；用法示例如下：*/
		/*
		Scanner in_switch = new Scanner(System.in);
		int choice = in_switch.nextInt();
		switch (choice) {
			case 1:
				System.out.println("This is a number one");
				break;
			case 2:
				System.out.println("This is a number two");
				break;
			case 3:
				System.out.println("This is a number Three");
				break;
			case 4:
				System.out.println("This is a number four");
				break;
			default :
				System.out.println("如果输入的整数都不符合上面四个case标签，则执行default标签分支语句");
				break;
		}
		*/
		/*1.case 后面的1、2叫做case标签，只能是整数或者枚举常量，不能是自字符串，例如case "asd"就会报错；
		 *2.default 关键字其作用类似于shell脚本case语句的 *) ，意思是如果不符合任何case 标签，就执行default语句分支的代码块；
		 *3.最重要的：如果某个case语句分支后没有break，此case语句代码块执行完成后，会接着执行下一个case语句分支，会出现严重错误；
		 */
		
		//循环语句控制—break和continue，用来跳出循环语句
		/*一种是不带标签的break循环控制，适用于不嵌套循环或者很浅的嵌套循环，遇到break之后直接跳出最外层循环*/
		double goal_3 = 9999999.88;
		System.out.println("退休时资产目标： " + goal_3);
		double payment_3 = 999999.88;
		System.out.println("每年最低收入：" + payment_3);
		double interestrate_3 = 1.7;
		System.out.println("每年最低年利率：" + interestrate_3 + "%");
		
		double balance_3 = 0;
		int years_3 = 0;
		//开始更新每年财务平衡
		while (years_3 <=20) {
			balance_3 += payment_3;
			double interest_3 = balance_3 * interestrate_3 / 100;
			balance_3 += interest_3;
			years_3++;
			if (balance_3 > goal_3) {//或者if (balance_3 > goal_3) break;
				System.out.println("目标达成！");
				break;//break之后不允许有任何代码
//				System.out.println("此行代码没意义，也不允许存在");
			}
//			System.out.println("此行代码共循环"+ years_3 +" 次");
		}
		System.out.println("他妈的累这么多年之后才能有充足的保障退休： " + years_3);

		/*另一种是带标签的break控制，在嵌套很深循环适用，在某层循环声明一个标签，在break跳出时指定跳出到该标签层次的循环*/
		int j = 1;
		inner_stop:
		while (j <=20) {
			j++;
			int i;
			for (i = 1;i <= 6;i++) {
				if (i==5) {//条件判断变量是否等于数字 用==
					//i = 5;
					System.out.println("\n共循环" + i +"次达到目标");
					break inner_stop;
				}
			}
		}
		/*continue跳出循环后，会从最外层循环开始接着执行，continue也有带标签的；而break直接打断循环，不会继续从循环最外层开始执行*/
		/*关于break和continue循环语句控制，在Java代码中几乎不用，不做重点掌握*/
		
		/**3.9大数值*/
		/*主要使用标准类库java.math包中的两个类：BigInteger和BigDecimal
		 *BigInteger类实现了任意精度的整数运算；BigDecimal类实现了任意精度的浮点数运算；
		 */
		int a_int = 10; int b_int = 26;
		BigInteger a = BigInteger.valueOf(a_int);//有些类可以不使用面向对象的特征，类直接调用类本身的方法
		BigInteger b = BigInteger.valueOf(b_int);
		BigInteger c1 = a.add(b);
		BigInteger c2 = b.subtract(a);
		BigInteger c3 = a.multiply(b);
		BigInteger c4 = b.divide(a);
		BigInteger c5 = b.mod(a);
		/*静态的valueOf()方法是把整型数值转换成大数值，add() subtract() multiply() divide() mod()五种方法，
		 *是对大数值进行 和、差、积、商、余数 的运算，大数值运算不能使用 + - *  / 等运算符，只能使用类的方法进行运算；
		 *上面是以BigInteger类为例讲述，,BigDecimal类也有类似效果的方法；
		 */
		
		/**3.10 数组——很重要的一种数据类型*/
		/*1.数组(即Array)是用来存储同一种类型(例如String、int、boolean等类型)的数据集合，是Java的一种数据结构；只能存储同一种数据类型；
		 *2.通过索引位访问数组中某个元素的值，例如int[0] String[2]，索引位从0开始；Java的数组中各元素形式上是用{ }括起来的，见后面数组初始化；
		 *3.声明数组变量时，要指出数组元素的类型，类型后紧跟[ ]，以及数组变量名；例如int [] array_int，这里只是声明了变量，并不是真正数组,并且
		 *	数组中每个元素必须是int类型；
		 *4.int[] array_int = new int[10]，后面的new int[10]表示创建数组对象，10代表共有10个元素；
		 *5.数组创建后，可以改变某个元素的值,但是不能改变长度；而后面讲的数组列表—Array list可以改变长度；
		 */
		
		//数组的基本定义方式和变量方式
		/*字符串类型的数组*/
		String[] aarr = new String[2];
		aarr[1] = "ww";//如果定义数组元素的具体值，前面不允许加数据类型
		/*整数类型的数组*/
		int[] zero = new int[0];//允许定义长度为0的数组，但不允许不声明长度
		int[] array_int = new int[4];//这种创建的数组叫做  动态数组
		/*数组创建后，所有元素是被初始化状态；int[]，String[]，boolean[]数组元素初始化为0 null false*/
		/*可以用for循环为数组每个元素赋值，如下：*/
		for (int i=0; i < 4; i++) {
			array_int[i] = i;
			System.out.println(array_int[i]);
		}
		System.out.println(array_int[2]);//通过索引位访问数组中某个元素的值
		System.out.println(array_int);//打印数组并不能输出{0,1,2,3}结构形式
		
		String[] array_Str = new String[4];//定义一个String类型数组变量，并创建初始化了的数组实例对象；
		for (String i : array_Str) {//for each循环遍历数组所有元素，循环条件中定义的暂存变量i要与数组类型匹配
			i = "qwe";//这里并没有给数组中每个元素赋值，而是赋值给了定义的变量i，后面打印array_Str就可证明
			System.out.println(i);
		}
		System.out.println("\n数组的长度： "+array_Str.length);//array_Str.length，得到数组长度，即元素个数
		System.out.println(Arrays.toString(array_Str));
		/*Arrays类中的toString()方法，也是遍历数组所有元素，但打印输出格式是列表形式[" "," "," "," "]*/
		
		//数组初始化以及匿名数组——共有2个知识点
		/*1.所谓数组初始化是指，创建数组实例对象后并赋予初值，这种创建的数组叫做  静态数组  */
		int[] array_small = {2,4,6,8};//数组手动赋值元素的方式
		System.out.println("初始化数组也不能输出{0,1,2,3}结构形式 "+array_small);
		/*2.匿名创建数组，是指不用声明新的数组变量，直接重新初始化一个数组变量值(即实例对象)，如下：*/
		array_small = new int[] {10,12,14};//注意数组实例对象不是静态的，是可以改变的，即在内存栈区变量值已经改变；
		System.out.println(Arrays.toString(array_small));
		/*Java中，无论哪种数据结构，包括ArrayList，只要数据中元素被手动赋值，都叫做初始化*/
		
		//数组拷贝
		/*数组拷贝就是把一个数组变量拷贝给另一个数组变量，变量值(即实例对象)并没有拷贝；
		 *这两个变量引用的是同一个数组，即在内存堆区的两个变量共同引用栈区的同一个变量值；
		 */
		int[] new_array_small_1 = array_small;
		System.out.println(Arrays.toString(new_array_small_1));
		new_array_small_1[1] = 16;//改变新数组变量中某个元素，旧的数组变量值也会改变，所以两个变量引用的是同一个数组变量值
		System.out.println("旧的数组变量值已经改变 "+Arrays.toString(array_small));
		
		/*如果希望不仅拷贝数组变量，而且把数组变量值也拷贝，那么需要使用Arrays类中的copyOf()方法，旧版本jdk用copyTo()方法；
		 *copyOf()方法，目前从学习进度看有两种常见方式：一是通过length 控制新数组长度，二是通过索引位的开始和终点控制新数组长度*/
		int[] new_array_small_2 = Arrays.copyOf(array_small, 2*array_small.length);
		System.out.println(Arrays.toString(new_array_small_2));
		/*第一个参数是原数组变量，第二个参数是新数组长度，若新数组长度大于旧数组，多余元素的值被初始化；若长度小于原始数组，则只拷贝最前面的元素*/
		int[] new_array_small_3 = Arrays.copyOfRange(array_small, 1,4);
		System.out.println("超出原数组的索引范围 "+Arrays.toString(new_array_small_3));
		/*第一个参数是原数组变量，第二个参数原数组索引位开始和终点，如果超出原数组范围，同样多余的元素的会被初始化；注意范围是左闭右开区间*/
		new_array_small_2[1] = 68;
		System.out.println("旧的数组变量值没有改变 "+Arrays.toString(array_small));
		/*总结：利用copyOf()方法拷贝数组，与上个拷贝方式不同，这是在栈区新建一个数组对象，新旧变量引用两个不同数组变量值*/
		
		//main方法的数组传参，参阅Main_book类定义的main方法
		
		//数组排序
		/*对数值型数组排序用Arrays类的sort()方法，排序为升序*/
		int[] sort_array = {2,3,9,8,6};
		Arrays.sort(sort_array);//这里只是对原数组进行元素排序，并不会产生新的数组变量
		System.out.println("排序后的数组 "+Arrays.toString(sort_array));
		
		/*数值类型之间int float double 强制转换；不加括号()，同一级别运算符从左到右执行，加括号则先运算括号内的*/
		double n1 = Math.random();
		System.out.println(n1);
		/*Math类的random()方法，随机返回一个在(0,1)区间的double类型的数值*/
		int n2 = (int) 0.34*10;//int(n2)，强制转换为整型数值
		System.out.println(n2);
		/*先执行类型强制转换(int) 0.34，然后执行乘以10 */
		int n3 = (int) (0.34*10);//两个不同类型数值运算，10会被自动强制转换为double类型；转换规则Google一下；
		System.out.println(n3);
		/*先执行0.34*10，然后把结果进行类型强制转换*/
		
		//多维数组——本质就是嵌套数组，最外层数组内的元素用第一个索引访问，第二层数组内的元素用第二个索引，本节简介一下，详情先跳过
		double[][] dimension_array_1 = new double[4][2];
		System.out.println("元素被初始化为0的二维数组 "+Arrays.deepToString(dimension_array_1));
		double[][] dimension_array_2 = {{1,2},{3,4},{5,6},{7,8}};
		System.out.println("元素被赋初值的二维数组 "+Arrays.deepToString(dimension_array_2));
		/*Arrays.deepToString()方法，打印多维数组*/
		
		String content = "\n以上是本书第三章输出内容";
		return content;
	}
}

