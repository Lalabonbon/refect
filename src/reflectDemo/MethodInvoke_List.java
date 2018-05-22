package reflectDemo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodInvoke_List {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<Integer> list2 = new ArrayList<Integer>();
        // 编译时，会校验list的类型，是否与泛型的类型相同
//        list2.add("sss");
        list1.add("Hello");
        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        System.out.println(c1 == c2);
        try {
            Method m1 = c1.getMethod("add", Object.class);
            m1.invoke(list1,12);
            System.out.println(list1.size());
            System.out.println(list1);
            for (Object obj : list1) {
                System.out.println(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
