package com.daily.pratice.concept.basic_concepts;

/**
 * Explains
 * method overriding - access privileges of a method in subclass cannot be weaker than those in superclass
 *                   - a final or a private method in a superclass cannot be overriden in a subclass
 *                   - overriding method can only throw subclass of exceptions thrown by overriden method.
 * method overloading - happens in the same class. two methods have same name but different parameters return types
 *
 * method hiding - static method in a subclass hides a static method with same name and signature in a superclass.
 */
public class MethodOptions {
    protected static void staticMethod() throws Exception {
        System.out.println("Static method in class MethodOptions");
    }
    protected MethodOptions instanceMethod(String str) throws Exception {
        System.out.println("Instance method in MethodOptions");
        return new MethodOptions();
    }
}
class MethodOptionsA extends MethodOptions {
    public static void staticMethod() throws ClassCastException {
        System.out.println("Static method in class MethodOptionsA");
    }
    @Override
    public MethodOptions instanceMethod(String str) throws Exception {
        System.out.println("Instance method in MethodOptionsA");
        return new MethodOptionsA();
    }
    public static void main(String[] args) throws Exception {
        MethodOptions mOpts = new MethodOptions();
        mOpts.instanceMethod("test");

        MethodOptions.staticMethod();

        mOpts = new MethodOptionsA();
        mOpts.instanceMethod("test");
        MethodOptionsA.staticMethod();
    }
}
