package com.daily.pratice.concept.basic_concepts.HashCodeEqualsDemo;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String args[]) {
        HashMap<OrdersAndInvoices, String> test = new HashMap<>();

        test.put(new PurchaseOrder(12345),"Sales Dept,Acme Inc");
        test.put(new Invoice("12345"), "Account Dept,Acme Inc");
        test.put(new Invoice("12346"),"Account Dept,IKM Inc");

        System.out.println(test.get(new PurchaseOrder(12345)));
        System.out.println(test.get(new Invoice("12345")));

    }

    static class PurchaseOrder implements OrdersAndInvoices {

        private Integer orderId = null;

        public PurchaseOrder(Integer newOrderId) {
            this.orderId = newOrderId;
        }

        @Override
        public boolean equals(Object anotherPurchaseOrder) {
            return anotherPurchaseOrder instanceof PurchaseOrder &&
                    this.orderId.equals(((PurchaseOrder) anotherPurchaseOrder).getOrderId());
        }
        @Override
        public int hashCode() {
            return this.orderId.intValue();
        }

        private Integer getOrderId() {
            return this.orderId;
        }
    }

    static class Invoice implements OrdersAndInvoices {
        private String relatedPurchaseOrderId;

        public int hashCode() {
            return Integer.parseInt(this.relatedPurchaseOrderId);
        }

        public Invoice(String purchaseOrderId) {
            this.relatedPurchaseOrderId = purchaseOrderId;
        }

    }
}