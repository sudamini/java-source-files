package com.daily.pratice.concept.basic_concepts.polymorphism;

public class Shape implements IDrawable  {
    @Override
    public void draw() {
        System.out.println("Drawing shape");
    }
    public void drawMe(){
        System.out.println("Should I draw myself");
    }
}
