package reflex.application;

import reflex.bean.Person;
import reflex.bean.ReflexBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 四种获取class实例
        // 第一种
        Class<ReflexBean> reflexBeanClass = ReflexBean.class;
        // 第二种
        ReflexBean reflexBean = new ReflexBean();
        Class<? extends ReflexBean> aClass = reflexBean.getClass();
        // 第三种
        Class<?> aClass1 = Class.forName("reflex.bean.ReflexBean");
        // 第四种
        Class<?> aClass2 = Test.class.getClassLoader().loadClass("reflex.bean.ReflexBean");


        /**
         * 获取相关信息
         */
        Class<?> aClass3 = Class.forName("reflex.bean.ReflexBean");
        Object o = aClass3.newInstance();// 获取运行时对象
        Field[] fields = aClass3.getFields(); // 获取字段
        Field[] declaredFields = aClass3.getDeclaredFields();//获取所有属性字段

        Method[] methods = aClass3.getMethods();// 获取方法
        Method[] declaredMethods = aClass3.getDeclaredMethods();// 获取所有方法

        Constructor<?>[] constructors = aClass3.getConstructors(); // 获取public构造器
        Constructor<?>[] declaredConstructors = aClass3.getDeclaredConstructors(); // 获取所有构造器


        /**
         * 调用字段实例
         */
        // 【调用指定的属性】
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();

        // 【1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性】
        Field name = clazz.getDeclaredField("name");
        // 【 2.保证当前属性是可访问的】
        name.setAccessible(true);
        // 【3.获取、设置指定对象的此属性值】
        name.set(p, "Tom");
        System.out.println(name.get(p));


        /**
         * 调用方法实例
         */
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        Object invoke = show.invoke(p);
        System.out.println(invoke);


        /**
         * 调用构造器
         */
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person gjc = (Person)declaredConstructor.newInstance("gjc");
        System.out.println(gjc.getName());



    }


}
