package annotations;

import java.lang.reflect.*;

public class AnnotationProcessor {
    public static void processDeprecatedEx(Class<?> clazz) {
        // Проверка класса
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.printf("Внимание: класс '%s' устарел. Альтернатива: '%s'%n",
                    clazz.getSimpleName(), annotation.message());
        }

        // Проверка методов
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.printf("Внимание: метод '%s' устарел. Альтернатива: '%s'%n",
                        method.getName(), annotation.message());
            }
        }
    }
}