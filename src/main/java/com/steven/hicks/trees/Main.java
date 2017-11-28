package com.steven.hicks.trees;

public class Main
{

    public static void main(String[] args)
    {
        Thread t = new Thread(new RunGame());
        t.start();
    }

}
