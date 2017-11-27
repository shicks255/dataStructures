package com.steven.hicks;

public class Main
{

    public static void main(String[] args)
    {
        Thread t = new Thread(new RunGame());
        t.start();
    }

}
