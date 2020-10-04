package com.psp;

public class Field {

    private Figure f1;
    private Figure f2;

    public Figure getf1() {
        return f1;
    }

    public void setf1(Figure f1) {
        this.f1 = f1;
    }

    public Figure getf2() {
        return f2;
    }

    public void setf2(Figure f2) {
        this.f2 = f2;
    }

    public enum Figure {
        STONE, PAPER, CSISSORS
    }
}
