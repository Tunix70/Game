package com.psp;

import java.util.Random;
import java.util.Scanner;

import com.psp.Field.*;

public class GameLogic {
    Field f = new Field();

    public void start(){
        getSetupInputUser();
        getSetupInputPC();
        checkWinner();
    }

    private void getSetupInputUser(){ //определяем вводом с консоли энам и присваеваем первому игроку
        f.setf1(getResultUser());
    }

    private void getSetupInputPC(){ //создаем массив из энам и присваиваем случайный элемент массива второму игроку
        Figure[] figures = {Figure.CSISSORS, Figure.PAPER, Figure.STONE};
        Random random = new Random();
        int a = random.nextInt(figures.length-1);
        f.setf2(figures[a]);
    }

      private Figure getResultUser(){
          Scanner scanner = new Scanner(System.in);
          String s;

          while (true) {
            s = scanner.nextLine();
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

    private String winner(Figure a, Figure b){
        if ((a.equals(Figure.STONE) && b.equals(Figure.STONE))
                || (a.equals(Figure.PAPER) && b.equals(Figure.PAPER))
                || (a.equals(Figure.CSISSORS) && b.equals(Figure.CSISSORS))) {
            return "Ничья";
        } else if ((a.equals(Figure.STONE) && b.equals(Figure.CSISSORS))
                || (a.equals(Figure.PAPER) && b.equals(Figure.STONE))
                || (a.equals(Figure.CSISSORS) && b.equals(Figure.PAPER))) {
            return "Игрок 1";
        } else if ((b.equals(Figure.STONE) && a.equals(Figure.CSISSORS))
                || (b.equals(Figure.PAPER) && a.equals(Figure.STONE))
                || (b.equals(Figure.CSISSORS) && a.equals(Figure.PAPER))) {
            return "Игрок 2";
        }
        return "Что-то работает не так";
    }

    private void checkWinner(){
        System.out.println("Победу одержал: " + winner(f.getf1(), f.getf2()));
    }

}
