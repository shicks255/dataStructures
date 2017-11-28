package com.steven.hicks.stacks;

public class Stack<T>
{
    private Node<T> top;
    private int numElements;

    public Stack()
    {
        top = null;
        numElements = 0;
    }

    public void push(T element)
    {
        top = new Node<T>(element, top);
        numElements++;
    }

    public T pop()
    {
        T returnValue;
        if (top == null)
            returnValue = null;
        else
        {
            returnValue = top.getData();
            top = top.getLink();
            numElements--;
        }

        return returnValue;
    }

    public int size()
    {
        return numElements;
    }

//--------Getters & Setters
    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }
}