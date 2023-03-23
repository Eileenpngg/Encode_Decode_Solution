import java.util.Random;

public class EncodeDecode {

    //find the ascii value of each letter and symbols
    //find the difference between the index and the ascii
    //create a variable string called encoded text;
    //create an attribute called random and set it as private
    //push random into encoded
    //loop through the plaintext and check the ascii of the character
    //ascii of the character - difference between ascii and index - random's index = encoded char
    //take encoded char and + difference between ascii and index and covert to char, push into encoded
    //return encoded string

    //(-/ (Index 36-43) (ascii value 40-47) -> difference is 4
    //0-9 (Index 26-35) (ascii value 48-57) -> difference is 22
    //A-Z (Index 0-25) (ascii value 65-90) -> difference is 65
    //a-z return its value or anything outside = char itself

    private Random random = new Random();
    private int randomAscii(){
        boolean randomBool= random.nextBoolean();
        if(randomBool){
            return random.nextInt(91-65)+65;
        }else{
            return random.nextInt(58-40)+40;
        }
    }

    private int asciiToIndex(int aChar){
        int index = 99;

        if(aChar >=65 && aChar<=90){
            index = aChar- 65;

        } else if (aChar >=40 && aChar<=47){
            index = aChar- 4;

        } else if (aChar >=48 && aChar<=57){
            index = aChar- 22;
        }
        return index;
    }
    private int indexToAscii(int index){
        int encodedCharAscii ;
        if(index<0){
            index= 44- Math.abs(index);
        }
        if(index >=0 && index<=25 ){
            encodedCharAscii= index + 65;
        } else if (index >=26 && index<=35 ){
            encodedCharAscii=index + 22;
        } else{
            encodedCharAscii=index + 4;
        }
        return encodedCharAscii;
    }

    private int encoding(int index, int offset) {
        int newIndex= index-offset;
        if(newIndex< 0){
            newIndex= 44- Math.abs(newIndex);
        }
        return indexToAscii(newIndex);
    }

    public String encode(String plainText){
        StringBuilder encodedText = new StringBuilder();
        int offset= randomAscii();
        encodedText.append((char)offset);
        int offsetIndex= asciiToIndex(offset);

        for(int i=0; i<plainText.length(); i++){
            char character= plainText.charAt(i);
            int charIndex= asciiToIndex(character);
            if(charIndex== 99){
                encodedText.append(character);
            } else {
                int encodedAscii = encoding(charIndex, offsetIndex);
                char encodedChar = (char) encodedAscii;
                encodedText.append(encodedChar);
            }
        }
        return encodedText.toString();
    }
    public String decode(String encodedText){

        char charoffset= encodedText.charAt(0);
        int offset= asciiToIndex(encodedText.charAt(0));
        System.out.println("char" + charoffset);
        System.out.println("offset" + offset);

        return "";
    }
}

