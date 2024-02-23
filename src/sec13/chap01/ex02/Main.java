package sec13.chap01.ex02;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static String objToString(Object obj) {
        Class<?> objClass = obj.getClass();

        StringBuilder sb = new StringBuilder();

        sb
                .append("ClassName : ")
                .append(objClass.getSimpleName())
                .append("\n");

        for (Field f : objClass.getDeclaredFields()) {

            //  💡 필드가 static인지 여부 확인
            //  - Modifier 클래스의 메서드들 확인해 볼 것
            if (Modifier.isStatic(f.getModifiers())) continue;

            f.setAccessible(true);
            try {
                sb.append(
                        " - %s (%s) : %s%n".formatted(
                                f.getName(),
                                f.getType().getSimpleName(),
                                f.get(obj)
                        )
                );
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return sb.toString();
    }

}
