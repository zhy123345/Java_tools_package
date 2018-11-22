package collection_operation;

import java.util.ArrayList;

public class Array_operation {
	
	public static void main(String[] args) {
		ArrayList<String> List_1 = new ArrayList<String>();
		List_1.add("q");
		List_1.add("w");
		List_1.add("e");
		List_1.add("r");
		
		ArrayList<String> List_2 = new ArrayList<String>();
		List_2.add("q");
		List_2.add("w");
		List_2.add("a");
		List_2.add("s");
		
		List_1.removeAll(List_2);//removeAll()方法，求两个数组列表的差集，返回的是布尔值；
		
		ArrayList<String> List_3 = new ArrayList<String>();
		List_3 = List_1;
		/*List_3 = List_1 是将List_3的地址值指向List_1,而List_3原先的对象会被垃圾回收；
		 *应该用下面的方法，把一个ArrayList变量赋值给另一个ArrayList变量；*/
		
		ArrayList<String> List_4 = new ArrayList<String>(List_1);//通过新创建对象的方式赋值
		ArrayList<String> List_5 = (ArrayList<String>)List_1.clone();//通过克隆的方法赋值
		
		StringBuilder new_array = new StringBuilder();
		System.out.println(new_array);
	}
}
