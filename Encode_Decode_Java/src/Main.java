public class Main {
    public static void main(String[] args) {

        char a='Z';
        int intA= a;
        System.out.println(intA);
        EncodeDecode encoder = new EncodeDecode();
        String plaintext = "HELLO WORLD";
        System.out.println(encoder.encode(plaintext));
    }
}
