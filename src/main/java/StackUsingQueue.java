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
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q.first();
    }

    @Override
    public void push(E e) {
        Objects.requireNonNull(e, "Null elements are not supported.");

        // Let ArrayQueue throw if full
        q.enqueue(e);

        // Rotate elements so new element becomes front
        for (int i = 0; i < q.size() - 1; i++) {
            q.enqueue(q.dequeue());
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q.dequeue();
    }
}
