package main_basic

import main_basic.basic_Syntax
import org.codehaus.groovy.runtime.GStringUtil;

class Main_primer {
  static void main(String[] args) {   //和Java一样，也是数组作为main方法的传参；
    println('Hello World');
    String aa = new String();
    aa.test01();

  }

  def GetString() { //def定义函数与其他方式定义函数不同区别是，无需指定返回值类型；而普通函数返回值return类型，是由方法类型决定，也就是说返回什么类型，是在定义方法时就已经决定好了的，以下一个为例说明；
    return "string"
  }
  public String test01() {  //这里定义的方法是String类型的，那么return返回值也必然是String类型的；再看下面的例子，虽然没有修饰符，但是groovy和Java是对方法有默认修饰符的；
    return "abc"
  }
  public test02() {
    return "qwe"
  }

  def aa=1;
}