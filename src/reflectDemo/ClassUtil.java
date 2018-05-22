package reflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
    public static void printClssMessage(Object obj) {
        // 1、得到obj对象的类的类类型
        Class c = obj.getClass();
        // 2、得到类的名称
        System.out.println("类名称：" + c.getName());
        // 3、得到了的方法
        // c.getMethods() 得到所有public范围的方法，包括从父类继承来的方法
        // c.getDeclaredMethods() 得到所有范围的自建的方法，不包括父类的方法
        Method[] ms = c.getMethods();
//        Method[] ms = c.getDeclaredMethods();
        for (int i = 0; i < ms.length; i++){
            // 得到方法的名称
            System.out.print(ms[i].getName() + "(");
            // 得到方法的参数类型
            Class[] paramType = ms[i].getParameterTypes();
            for (Class class1 : paramType) {
                System.out.print(class1 + ",");
            }
            System.out.print(") ");
            // 得到方法的返回类型
            Class returnType = ms[i].getReturnType();
            System.out.println(returnType.getName());
        }
    }

    public static void printFieldMessage(Object obj) {
        Class c = obj.getClass();
        // c.getFields() 表示所有共有的成员变量
        // c.getDeclaredFields() 表示该类对象所表示的类的所有成员变量
//            Field[] fs = c.getFields();
        Field[] fs = c.getDeclaredFields();
        for (Field f : fs){
            System.out.print("成员变量的名称：" + f.getName());
            System.out.println(" 成员变量的类型：" + f.getType());
        }
    }

    public static void printConMessage(Object obj){
        Class c = obj.getClass();
        Constructor[] con = c.getDeclaredConstructors();
        for (Constructor con1 : con) {
            System.out.print("构造方法的名称：" + con1.getName() + "(");
            Class[] paramTypes = con1.getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1.getName() + " ");
                System.out.print(class1.getTypeName() + ",");
            }
            System.out.println(")");
        }
    }
}
