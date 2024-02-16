/**
 * MyLinkedListException은 MyLinkedList 클래스에서 발생할 수 있는 예외 상황을 처리하기 위한 사용자 정의 예외 클래스입니다.
 * 이 클래스를 통해 MyLinkedList의 특정 동작에 대한 예외 정보를 더 구체적으로 제공합니다.
 */
public class MyLinkedListException extends RuntimeException{
    public MyLinkedListException(String message) {
        super(message);
    }
}
