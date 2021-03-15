package anno.application;

import anno.config.MyField;
import anno.use.MyFieldUse;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) {

        // 通过反射获取注解字段的信息
        Class<MyFieldUse> myFieldUseClass = MyFieldUse.class;
        for (Field field : myFieldUseClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyField.class)) {
                MyField annotation = field.getAnnotation(MyField.class);
                System.out.println(annotation.description() + ":" + annotation.length());
            }
        }
    }

}
