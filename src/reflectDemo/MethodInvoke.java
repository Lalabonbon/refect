package reflectDemo;

import java.lang.reflect.Method;

/**
 * 方法的反射
 * 先获得类的类类型，然后通过c.getMethod()方法指定相对应的方法
 * 通过获得的Method对象调用invoke()方法来进行反射调用方法
 */
public class MethodInvoke {
    public static void main(String[] args) {
        A a = new A();
        Class c = a.getClass();
        try {
//            Method m = c.getMethod("print", new Class[]{int.class,int.class});
//            m.invoke(a,new Object[]{1,2});
            // 调用print(int a, int b)
            Method m = c.getMethod("print", int.class, int.class);
            m.invoke(a, 23, 34);
            // 调用print(String a, String b)
            Method m1 = c.getMethod("print", String.class, String.class);
            m1.invoke(a,"Hello", "World");
            // 调用print()方法
            Method m2 = c.getMethod("print");
            m2.invoke(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A{
    public void print(int a, int b){
        System.out.println(a + b);
    }
    public void print(String a,String b){
        System.out.println(a + "," + b);
    }
    public void print(){
        System.out.println("HelloWorld!");
    }
}
