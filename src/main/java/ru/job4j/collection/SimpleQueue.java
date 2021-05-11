package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int inValue;
    private int outValue;

    public T poll() {
        if (outValue == 0) {
            while (inValue != 0) {
                out.push(in.pop());
                inValue--;
                outValue++;
            }
        }
        outValue--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        inValue++;

    }
}
