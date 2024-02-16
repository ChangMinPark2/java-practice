/**
 * 하위과제 MyLinkedList를 이용해서 Queue 만들기.
 */
public class Queue <T>{
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void offer(T data) {
        list.add(data);
    }

    public T poll() {
        if (list.size() == 0) throw new MyLinkedListException("큐의 값이 비어있으므로 dequeue() 메소드를 사용하실 수 없습니다.");
        T data = list.get(0);
        list.delete(0);
        return data;
    }
}
