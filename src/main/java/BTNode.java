public class BTNode<T>
{
    private T data;
    private BTNode<T> right;
    private BTNode<T> left;

    public BTNode(T data, BTNode<T> right, BTNode<T> left)
    {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    public BTNode()
    {}




    //------Getters & Setters

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public BTNode<T> getRight()
    {
        return right;
    }

    public void setRight(BTNode<T> right)
    {
        this.right = right;
    }

    public BTNode<T> getLeft()
    {
        return left;
    }

    public void setLeft(BTNode<T> left)
    {
        this.left = left;
    }
}
