package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge {
    private static final int result = 10;

    @Override
    public int getCarsCount(){
        return result;
    }
}
