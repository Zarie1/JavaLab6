import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract public class MyLinkedList implements Iterable<Vagon> {

    protected Node head;
    protected Node tail;
    protected int size;

    // Внутрішній клас для вузла списку
    protected static class Node {
        Vagon data;
        Node next;
        Node prev;

        Node(Vagon data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    // Порожній конструктор
    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    // Конструктор для створення колекції з одного елемента
    public MyLinkedList(Vagon element) {
        this();
        add(element);  // Додаємо елемент до списку
    }


    public MyLinkedList(Collection<? extends Vagon> collection) {
        this();
        addAll(collection);
    }
    public boolean addAll(Collection<? extends Vagon> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }

        // Додаємо всі елементи з колекції до списку
        for (Vagon vagon : collection) {
            add(vagon);  // Використовуємо існуючий метод add для додавання елементів
        }

        return true;
    }
    public int size() {
        return size;
    }

    public boolean add(Vagon vagon) {
        Node newNode = new Node(vagon);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    public Vagon remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = getNodeAt(index);
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        size--;
        return current.data;
    }

    public Node getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public Iterator<Vagon> iterator() {
        return new Iterator<Vagon>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Vagon next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Vagon data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
