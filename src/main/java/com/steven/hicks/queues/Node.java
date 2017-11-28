package com.steven.hicks.queues;

public class Node<T>
{
    private T data;
    private Node<T> link;

    public Node(T initialData, Node<T> initialLink)
    {
        data = initialData;
        link = initialLink;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T initialData)
    {
        data = initialData;
    }

    public Node getLink()
    {
        return link;
    }

    public void setLink(Node<T> initialLink)
    {
        link = initialLink;
    }
}