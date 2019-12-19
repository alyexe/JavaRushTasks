package com.javarush.task.task14.task1408;

class UkrainianHen extends Solution.Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 6;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
