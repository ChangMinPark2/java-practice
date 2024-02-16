/**
 * 하위과제 MyLinkedList를 이용해서 Stack 만들기.
 */
public class Stack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T data) {
        list.add(data);
    }

    public T pop() {
        if (list.size() == 0) {
            throw new MyLinkedListException("스택의 값이 비어있으므로 pop() 메소드를 사용하실 수 없습니다.");
        }

        T data = list.get(list.size() - 1);
        list.delete(list.size() - 1);

        return data;
    }
}
