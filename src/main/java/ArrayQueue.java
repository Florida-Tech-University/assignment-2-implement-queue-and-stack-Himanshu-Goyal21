import java.util.Objects;
import java.util.Arrays;
public class ArrayQueue<E>
    implements QueueADT<E>
    {
    private final E[] data;
    private int front = 0;
    private int rear = 0;
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        // We add 1 because one slot is always left empty in a circular array
        this.data = (E[]) new Object[capacity + 1];
    }
    @Override
    public int size() {
        return (rear - front + data.length) % data.length;
    }
    @Override
    public boolean isEmpty() {
        return front == rear;
    }
    public boolean isFull() {
        return (rear + 1) % data.length == front;
    }
    @Override
    public E first() {
        return isEmpty() ? null : data[front];
    }
    @Override
    public void enqueue(E e) {
        Objects.requireNonNull(e, "Null elements are not supported.");
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        
        data[rear] = e;
        rear = (rear + 1) % data.length;
    }
    @Override
    public E dequeue() {
        if (isEmpty()) return null;

        E answer = data[front];
        data[front] = null; // Prevent memory leak (loitering)
        front = (front + 1) % data.length;
        return answer;
    }
    public int capacity() { 
        return data.length - 1; 
    }
    @Override
    public String toString() {
        return "Queue(front=" + front + ", rear=" + rear + ", size=" + size() + ")";
    }
}
