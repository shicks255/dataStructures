import java.util.Scanner;

public class RunGame implements Runnable
{
    Scanner in = new Scanner(System.in);

    public void run()
    {
        System.out.println("I will try to guess your animal");

        boolean keepGoing = true;

        while (keepGoing)
        {

        }
    }

    //:todo probably a better way to implement this
    public BTNode<String> initializeAnswerTree()
    {
        BTNode<String> root = new BTNode<String>("Is it a mammal?", null, null);

        BTNode<String> t = new BTNode<String>("", null, null);

        return root;
    }
}
