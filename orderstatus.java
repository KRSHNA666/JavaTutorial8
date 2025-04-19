enum OrderStatus {
    PLACED, SHIPPED, DELIVERED, CANCELLED
}

public class OrderSystem {
    public static void main(String[] args) {
        OrderStatus status = OrderStatus.SHIPPED;

        switch (status) {
            case PLACED -> System.out.println("Your order has been placed successfully!");
            case SHIPPED -> System.out.println("Your order is on the way!");
            case DELIVERED -> System.out.println("Your order has been delivered. Enjoy!");
            case CANCELLED -> System.out.println("Your order has been cancelled.");
        }
    }
}
