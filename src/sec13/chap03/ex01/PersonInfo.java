package sec13.chap03.ex01;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfo {
    //  💡 다른 어노테이션을 항목으로 가짐
    PersonName personName();
    int age();
    boolean married();
}
