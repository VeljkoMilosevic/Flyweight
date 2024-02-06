package desing.pattern.main;


import desing.pattern.client.Client;

public class Main {

    public static void main(final String[] args) {
        final Client client = new Client();
        client.createNewCircles();
        client.createNewCirclesFlyweight();
    }
}