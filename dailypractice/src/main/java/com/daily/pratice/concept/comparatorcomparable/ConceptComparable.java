package com.daily.pratice.concept.comparatorcomparable;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.jetbrains.annotations.NotNull;

import java.util.*;

class ConceptComparable {
    private static List<Laptop> myLaptops = new ArrayList<>();

    public static void main ( String[] args ) {

        myLaptops.add( new Laptop("DELL",800, 10));
        myLaptops.add( new Laptop("APPLE", 1200, 20));
        myLaptops.add(new Laptop("ACER", 500, 5));

        List<Integer> ints = Arrays.asList(100,2,3,56,7,8,11);
        Collections.sort(ints);
        Collections.sort(myLaptops);
        System.out.println (myLaptops.toString());

        Collections.sort(myLaptops, new Comparator<Laptop>() {
            @Override
            public int compare(Laptop o1, Laptop o2) {
                if( o1.getBrand().compareTo(o2.getBrand() ) < 1 ) {
                    return -1;
                } else if (o1.getBrand().compareTo(o2.getBrand()) > 1 ) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println (myLaptops.toString());


    }

    private static class Laptop implements Comparable<Laptop> {

        @Override
        public int compareTo(@NotNull ConceptComparable.Laptop o) {
            if( Integer.compare( this.price, o.price ) > 1 )  {
                return 1;
            } else if ( Integer.compare( this.price, o.price ) < 1 ) {
                return -1;
            } else
                return 0;
        }

        @Override
        public String toString() {
            return "Laptop{" +
                    "brand='" + brand + '\'' +
                    ", price=" + price +
                    ", ram_size=" + ram_size +
                    '}';
        }

        String brand;
        int price;
        int ram_size;
        @Ignore
        Laptop(String brand, int price, int ram_size) {
            this.brand = brand;
            this.price = price;
            this.ram_size = ram_size;
        }
        @Ignore
        String getBrand() {
            return brand;
        }
        @Ignore
        void setBrand(String brand) {
            this.brand = brand;
        }
        @Ignore
        int getPrice() {
            return price;
        }
        @Ignore
        void setPrice(int price) {
            this.price = price;
        }
        @Ignore
        int getRam_size() {
            return ram_size;
        }
        @Ignore
        void setRam_size(int ram_size) {
            this.ram_size = ram_size;
        }
    }
}
