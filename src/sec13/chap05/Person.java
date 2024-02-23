package sec13.chap05;

/**
 * 한 사람을 나타내는 클래스입니다.
 * @author yalco
 * @version 2.0
 */
public class Person {

    /**
     * 사람의 이름입니다.
     */
    private String name;

    /**
     * 사람의 나이입니다.
     */
    private int age;

    /**
     * 이름과 나이를 받는 생성자입니다.
     * @param name  사람의 이름
     * @param age 사람의 나이
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
