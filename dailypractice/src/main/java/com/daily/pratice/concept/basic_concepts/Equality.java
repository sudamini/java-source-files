package com.daily.pratice.concept.basic_concepts;

/**
 * Overriding equals() method to test object value equality.
 * Object class tests object reference equality by default but we mostly want to test for logical equality.
 */
final class Equality {

    public static void main( final String[] args) {
        Test test1 = new Test("abc", 10, "grandview");
        Object test2 = new Test("abc", 10, "grandview");
        Object test3 = new Test1();
        System.out.println(test1.equals(test2));
        System.out.println(test2.equals(test3));

    }

    private static class Test {
        String name;
        double value;
        String address;

        Test(String name, double value, String address) {
            this.name = name;
            this.value = value;
            this.address = address;
        }
        @Override
        public boolean equals( Object that ) {
            //if they are same objects, return true.
            if( this == that ) {
                return true;
            }
            //if parameter object is not instance of this class or one of its subclasses, return false.
            if( that instanceof Test ){
                Test other = (Test) that;
                if( this.name.equals(other.name) && (this.value == other.value ) && (this.address.equals(other.address))){
                    return true;
                }
            }
            return false;
        }
    }

    private static class Test1 extends Test {
        Test1(){
            super("tanuj",11,"grandview");
        }
    }

}
