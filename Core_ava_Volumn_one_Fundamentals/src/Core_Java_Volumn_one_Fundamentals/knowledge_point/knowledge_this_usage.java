package Core_Java_Volumn_one_Fundamentals.knowledge_point;

public class knowledge_this_usage {
    int i = 0;
    public knowledge_this_usage(int i) {    //这是带参数的构造方法，构造方法是用来初始化一个新的对象，在new对象之后自动调用；
        this.i = i;
        System.out.println(this);
    }
    public knowledge_this_usage increament() {
        i++;
        System.out.println(i);
        System.out.println(this);
        return this;//运行此代码后通过上条语句可知，哪个实例调用此方法，this就是指哪个实例；这个实例对象是通过当前类knowledge_this_usage创建的，所以此实例对象是knowledge_this_usage类型；而又因为return返回类型必须和方法类型一致，所以只能用类名knowledge_this_usage修饰方法；
                    //这里在补充一下方法类型和类的关系，其实从这个方法定义中可以看出，类名就代表了方法的类型；
    }
    public void print() {
        System.out.println("i = " + 1);
    }
}