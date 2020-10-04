package com.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.psp.Field.*;

public class GameLogic {
    Field f = new Field();

    public void getSetupInputUser() throws IOException { //определяем вводом с консоли энам и присваеваем первому игроку
        f.setf1(getResultUser());
    }

    public void getSetupInputPC(){ //создаем массив из энам и присваиваем случайный элемент массива второму игроку
        Figure[] figures = {Figure.CSISSORS, Figure.PAPER, Figure.STONE};
        Random random = new Random();
        int a = random.nextInt(figures.length-1);
        f.setf2(figures[a]);
    }

    public Figure getResultUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (true) {
            s = reader.readLine();
            if (s.equals("Камень") || s.equals("Ножницы") || s.equals("Бумага")) {
                break;
            }
        }
        if(s.equals("Камень"))
            return Figure.STONE;
        else if (s.equals("Ножницы"))
            return Figure.CSISSORS;
        else
            return Figure.PAPER;
    }
    public void start() throws IOException {
        getSetupInputUser();
        getSetupInputPC();
        winner(f.getf1(), f.getf2());

    }

    public void winner(Figure a, Figure b) {
        if ((a.equals(Figure.STONE) || b.equals(Figure.STONE))
                && (a.equals(Figure.PAPER) || b.equals(Figure.PAPER))
                && (a.equals(Figure.CSISSORS) || b.equals(Figure.CSISSORS))) {
            System.out.println("Ничья!");
        } else if ((a.equals(Figure.STONE) || b.equals(Figure.CSISSORS))
                && (a.equals(Figure.PAPER) || b.equals(Figure.STONE))
                && (a.equals(Figure.CSISSORS) || b.equals(Figure.PAPER))) {
            System.out.println("Игрок " + a + " победил!");
        } else if ((b.equals(Figure.STONE) || a.equals(Figure.CSISSORS))
                && (b.equals(Figure.PAPER) || a.equals(Figure.STONE))
                && (b.equals(Figure.CSISSORS) || a.equals(Figure.PAPER))) {
            System.out.println("Игрок " + b + " победил!");
        }
        else System.out.println("Что-то ты накосячил в этом методе");
    }
}
