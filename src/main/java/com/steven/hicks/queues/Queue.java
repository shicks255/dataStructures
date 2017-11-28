package com.steven.hicks.queues;

public class Queue<T>
{
    private Node<T> front;
    private Node<T> rear;
    private int numElements;

    public Queue()
    {
        front = null;
        rear = null;
        numElements = 0;
    }

    public int size()
    {
        return numElements;
    }

    public void add(T element)
    {
        if (rear == null)
        {
            front = new Node<T>(element, null);
            rear = front;
        }
        else
        {
            rear.setLink(new Node<T>(element, null));
            rear = rear.getLink();
        }
        numElements++;
    }

    public T remove()
    {
        T value;

        if (front == null)
            value = null;
        else
        {
            value = front.getData();
            if (front != null)
            {
                front = front.getLink();
            }
            else
            {
                front = null;
                rear = null;
            }
            numElements--;
        }
        return value;
    }


    public Node<T> getFront() {
        return front;
    }

    public void setFront(Node<T> front) {
        this.front = front;
    }

    public Node<T> getRear() {
        return rear;
    }

    public void setRear(Node<T> rear) {
        this.rear = rear;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }
}
