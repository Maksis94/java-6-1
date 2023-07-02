package ru.netology.services;

public class IncomeService {
    public int calculate(int income, int expenses, int threshold) {
        int count = 0; // счётчик месяцев отдыха
        int money = 0; // количество денег на счету

        for (int month = 1; month <= 12; month++) {
            int prevMoney = money;

            if (money >= threshold) { // можем ли отдыхать?
                count++; // увеличиваем счётчик месяцев отдыха
                money -= expenses;

                int leftover = money * 1 / 3;
                int spent = money - leftover;
                money = leftover;

                //System.out.println("Месяц " + month + ". Денег " + prevMoney + ". Буду отдыхать. Потратил -" + expenses + ", затем ещё -" + spent);
            } else {
                money += income - expenses;
                //System.out.println("Месяц " + month + ". Денег " + prevMoney + ". Придётся работать. Заработал +" + income + ", потратил -" + expenses);
            }
        }

        return count;
    }
}
