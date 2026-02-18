public interface StackADT<E> {
    int size();
    boolean isEmpty();

    /**
     * Returns the top element without removing it.
     * If empty, returns null.
     */
    E top();

    /**
     * Adds an element to the top of the stack.
     * If the stack is full (capacity), throw IllegalStateException.
     */
    void push(E e);

    /**
     * Removes and returns the top element.
     * If empty, returns null.
     */
    E pop();
}
