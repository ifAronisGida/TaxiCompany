package com.codecool.taxi;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i < 52; i++) {
            company.simulateOneWeek();
        }
    }
}
