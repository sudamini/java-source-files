package com.daily.pratice.concept.basic_concepts.polymorphism;

final class PolymorphRefs {
    public static void main(final String[] args ){
        Shape[] shapes = { new Circle(), new Rectangle(), new Square(), new Shapeless()};
        IDrawable[] drawables = { new Shape(), new Rectangle(), new Map(),new Shapeless() };
        System.out.println("Draw shapes");

        for ( int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
            shapes[i].drawMe(); // superclasses dont implement this, so they will get inherited version
        }

        System.out.println("Draw drawables");

        for ( int i = 0; i < shapes.length; i++) {
            drawables[i].draw();
        }

    }
}
