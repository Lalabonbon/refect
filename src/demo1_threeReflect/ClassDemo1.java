package demo1_threeReflect;

public class ClassDemo1 {
    public static void main(String[] args) {
        // foo是Foo的实例对象
        Foo foo = new Foo();
        // 而Foo是Class(java.lang.Class)的实例对象
        // 任何一个类都是Class的实例对象
        // 创建Class的实例对象的三种方法
        // c1,c2,c3都是Foo的类类型
        // 1、任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;
        // 2、
        Class c2 = foo.getClass();

        Class c3 = null;
        try {
            c3 = Class.forName("demo1_threeReflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 通过Foo的类类型，可以创建Foo的实例对象
        try {
            Foo foo1 = (Foo)c1.newInstance();
            foo1.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
class Foo{
    public void print(){
        System.out.println("foo....");
    }
}
