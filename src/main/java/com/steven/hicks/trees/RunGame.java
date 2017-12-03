package com.steven.hicks.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RunGame implements Runnable
{
    Scanner key = new Scanner(System.in);

    public void run()
    {
//        BTNode<String> root = initializeAnswerTree();
        BTNode<String> root = createTreeFromXML();

        printInstructions();

        do
        {
            play(root);
        }
        while(query("Shall we play again?"));

    }

    public void play(BTNode<String> currentNode)
    {
        while(!currentNode.isLeaf())
        {
            if (query(currentNode.getData()))
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        }

        System.out.println("My guess is " + currentNode.getData());
        if (!query("Am I right?"))
            learn(currentNode);
        else
            System.out.println("I knew it all along!");
    }

    public boolean query(String query)
    {
        System.out.println(query);
        System.out.println("Type Y for 'yes' or N for 'no'.\r\n");

        String answer = key.nextLine();
        if (answer.equalsIgnoreCase("y"))
            return true;
        else
            return false;
    }

    public BTNode<String> createTreeFromXML()
    {
        BTNode<String> root = null;

        InputStream inputStream = Main.class.getResourceAsStream("../../../../classes/animalTree.xml");

        root = parseXML();
        return root;
    }

    private BTNode<String> parseXML()
    {
        InputStream inputStream = Main.class.getResourceAsStream("../../../../../classes/animalTree.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        BTNode<String> root = new BTNode<String>();

        Map<Integer, BTNode> allNodes = new HashMap<>();

        try
        {
            while (reader.ready())
            {
                String line = reader.readLine();

                if (line.contains("<node"))
                {
                    root.setData(line.substring(line.indexOf("data=\"")+5, line.indexOf(">")-1));
                    String id = line.substring(line.indexOf("id=\"")+4, line.indexOf("id=\"")+8);
                    String parent = line.substring(line.indexOf("parent=\"")+8, line.indexOf("parent\"") + 12);
                }

                if (line.contains("<left"))
                {
                    BTNode<String> newLeft = new BTNode<String>();
                    newLeft.setData(line.substring(line.indexOf("data=\"")+5, line.indexOf(">")-1));
                    String id = line.substring(line.indexOf("id=\"")+4, line.indexOf("id=\"")+8);
                    String parent = line.substring(line.indexOf("parent=\"")+8, line.indexOf("parent=\"")+12);
                }

                if (line.contains("<right"))
                {
                    BTNode<String> newRight = new BTNode<String>();
                    newRight.setData(line.substring(line.indexOf("data=\"")+5, line.indexOf(">"b)-1));
                    String id = line.substring(line.indexOf("id=\"")+4, line.indexOf("id\"")+8);
                    String parent = line.substring(line.indexOf("parent=\"")+8, line.indexOf("parent=\"")+12);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    //:todo probably a better way to implement this
    public BTNode<String> initializeAnswerTree()
    {
        final String ROOT_QUESTION = "Are you a mammal?";
        final String LEFT_QUESTION = "Are you bigger than a cat?";
        final String RIGHT_QUESTION = "Do you live underwater?";
        final String ANIMAL1 = "Kangaroo";
        final String ANIMAL2 = "MOUSE";
        final String ANIMAL3 = "Trout";
        final String ANIMAL4 = "Robin";

        //create root node with root question
        BTNode<String> root = new BTNode<String>(ROOT_QUESTION, null, null);
        //create and attach left subtree.
        BTNode<String> child = new BTNode<String>(LEFT_QUESTION, null, null);
        child.setLeft(new BTNode<String>(ANIMAL1, null, null));
        child.setRight(new BTNode<String>(ANIMAL2, null, null));
        root.setLeft(child);
        //create and attach the right subtree
        child = new BTNode<String>(RIGHT_QUESTION, null, null);
        child.setLeft(new BTNode<String>(ANIMAL3, null, null));
        child.setRight(new BTNode<String>(ANIMAL4, null, null));
        root.setRight(child);

        return root;
    }

    public void printInstructions()
    {
        System.out.println("Think of an animal\r\n");
        System.out.println("I will try to guess your animal");
    }

    public void learn(BTNode<String> currentNode)
    {
        BTNode<String> oldAnswer = new BTNode<String>(currentNode.getData(), null, null);
        System.out.println("Enter the animal you were thinking of.");
        String newAnimal = key.nextLine();

        System.out.println("Now enter an affirmitive question for this animal");
        String newQuestion = key.nextLine();

        currentNode.setData(newQuestion);
        currentNode.setLeft(new BTNode<String>(newAnimal, null, null));
        currentNode.setRight(oldAnswer);
    }
}
