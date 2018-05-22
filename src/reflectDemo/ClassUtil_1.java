package reflectDemo;

import java.lang.reflect.Method;

public class ClassUtil_1 {
    public static void printClassMessage(Object obj){
        Class c = obj.getClass();
        // 获取类的名称
        System.out.println("类的名称：" + c.getName());
        // 获取类的方法
        // c.getMethods() 获取所有public
        Method[] ms = c.getMethods();
        for (int i = 0; i < ms.length; i++){
            // 获取方法的返回类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            // 获取方法的名称
            System.out.print(ms[i].getName() + "(");
            // 获取方法的参数类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class class1 : paramTypes) {
                System.out.print(class1 + ",");
            }
            System.out.println(")");
        }
    }
}
