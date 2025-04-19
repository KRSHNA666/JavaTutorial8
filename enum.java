enum TrafficSignal {
    RED, YELLOW, GREEN
}

public class TrafficControl {
    public static void main(String[] args) {
        TrafficSignal signal = TrafficSignal.RED;

        switch (signal) {
            case RED -> System.out.println("Stop");
            case YELLOW -> System.out.println("Wait");
            case GREEN -> System.out.println("Go");
        }
    }
}
