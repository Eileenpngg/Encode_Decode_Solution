public class Main {
    public static void main(String[] args) {
        EncodeDecode encoder = new EncodeDecode();
        String plainText = "HELLO WORLD";
        String encodedText = encoder.encode(plainText);
        System.out.println("encodedText" + encodedText);
        System.out.println(encoder.decode(encodedText));
    }
}
