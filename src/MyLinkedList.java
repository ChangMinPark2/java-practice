import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * add() 메소드
     * 마지막 노드에 데이터를 추가 할 수 있다.
     */
    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int size() {
        return size;
    }

    /**
     * get(int index) 메소드
     * index 번째 노드의 데이터를 반환합니다.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new MyLinkedListException("입력하신 인덱스 " + index + "는 유효한 범위가 아닙니다.");
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * delete (int index) 메소드
     * index 번째 노드의 데이터를 삭제합니다.
     */
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new MyLinkedListException("입력하신 인덱스 " + index + "는 유효한 범위가 아닙니다.");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }

            Node<T> current = previous.next;
            previous.next = current.next;

            if (current == tail) {
                tail = previous;
            }
        }

        size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        /**
         하위 과제 for - each로 순회 가능하다.
         */
        for (int i : list) {
            System.out.println("List의 각 요소들 입니다. : " + i);
        }

        Queue<Integer> queue = new Queue<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println("큐의 첫 번째로 나온 값 : " + queue.poll());
        System.out.println("큐의 두 번째로 나온 값 : " + queue.poll());

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        System.out.println("스택의 첫 번째로 나온 값 : " + stack.pop());
        System.out.println("스택의 두 번째로 나온 값 : " + stack.pop());
    }
}

