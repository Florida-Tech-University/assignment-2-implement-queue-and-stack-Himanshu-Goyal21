import java.util.Objects;

public class StackUsingQueue<E> implements StackADT<E> {
    private final ArrayQueue<E> q; // Changed to ArrayQueue to access capacity()

    public StackUsingQueue(int capacity) {
        // The queue needs to be the same size as the stack's intended capacity
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
        // In a stack, top() is the last element added.
        // Because of our push rotation, this is the front of the queue.
        return q.first();
    }

    @Override
    public void push(E e) {
        Objects.requireNonNull(e, "Null elements are not supported.");
        
        // Manual check for full status since the Queue is our backing store
        if (q.size() == q.capacity()) {
            throw new IllegalStateException("Stack is full");
        }

        q.enqueue(e);
        
        // Rotate the queue so the newly added element is at the front
        int rotations = q.size() - 1;
        for (int i = 0; i < rotations; i++) {
            q.enqueue(q.dequeue());
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        return q.dequeue();
    }
}
