package challenges.tiktok.May2021;

import java.util.Stack;

public class ImmutableStack<T> {

    private final Stack<T> stack;

    public ImmutableStack(Stack<T> stack) {
        this.stack = new Stack<>();
        this.stack.addAll(stack);
    }

    public ImmutableStack() {
        stack = new Stack<>();
    }

    public ImmutableStack<T> push(T item) {
        ImmutableStack<T> result = new ImmutableStack<>(stack);
        result.stack.push(item);
        return result;
    }

    public ImmutableStack<T> pop() {
        ImmutableStack<T> result = new ImmutableStack<>(stack);
        result.stack.pop();
        return result;
    }

    public Integer size() {
        return stack.size();
    }

    public T top() {
        return stack.peek();
    }


    public static void main(String[] args) {
        ImmutableStack<Integer> a = new ImmutableStack<>();
        System.out.println(a.size());
        ImmutableStack<Integer> b = a.push(100);
        System.out.println(a.size());
        System.out.println(b.size());
        System.out.println(b.top());
        ImmutableStack<Integer> c = b.push(101);
        System.out.println(b.size());
        System.out.println(b.top());
        System.out.println(c.size());
        System.out.println(c.top());
        ImmutableStack<Integer> d = b.pop();
        System.out.println(b.size());
        System.out.println(b.top());
        System.out.println(d.size());

    }
}
