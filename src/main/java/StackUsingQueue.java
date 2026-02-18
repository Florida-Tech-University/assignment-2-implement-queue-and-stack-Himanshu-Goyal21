import java.util.Objects;

public class StackUsingQueue<E> implements StackADT<E> {
    private final ArrayQueue<E> q;

    public StackUsingQueue(int capacity) {
        this.q = new ArrayQueue<>(capacity);
    }

    @Override
    public int size() {
        return q.size();
    }

    @Override
    public boolean isEmpty() {
        return q.isEmpty();
    }

    @Override
    public E top() {
        return q.first();
    }

    @Override
    public void push(E e) {
        Objects.requireNonNull(e, "Null elements are not supported in this assignment.");
        
        // Check if queue is full
        if (q.size() == q.capacity()) {
            throw new IllegalStateException("Stack is full");
        }
        
        q.enqueue(e);
        
        // Rotate the queue so the newly added element is at the front
        for (int i = 0; i < q.size() - 1; i++) {
            q.enqueue(q.dequeue());
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        return q.dequeue();
    }
}
