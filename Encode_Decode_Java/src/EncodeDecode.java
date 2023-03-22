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


//    private int random(){
//
//
//    }
    char randomChar= 'B';
    int randomCharAscii= 1;
    private int getEncodedCharIndex(char aChar){
        int asciiChar= aChar;
        int encodedCharIndex = 99;

        if(asciiChar >=65 && asciiChar<=90){
            encodedCharIndex = asciiChar- randomCharAscii- 65;

        } else if (asciiChar >=40 && asciiChar<=47){
            encodedCharIndex = asciiChar- randomCharAscii- 4;

        } else if (asciiChar >=48 && asciiChar<=57){
            encodedCharIndex = asciiChar- randomCharAscii- 22;
        }
        return encodedCharIndex;
    }
    private int getEncodedAscii(int encodedCharIndex){
        int encodedCharAscii ;
        if(encodedCharIndex<0){
            encodedCharIndex= 44- Math.abs(encodedCharIndex);
        }
        if(encodedCharIndex >=0 && encodedCharIndex<=25 ){
            encodedCharAscii= encodedCharIndex + 65;
        } else if (encodedCharIndex >=26 && encodedCharIndex<=35 ){
            encodedCharAscii=encodedCharIndex + 22;
        } else{
            encodedCharAscii=encodedCharIndex + 4;
        }
        return encodedCharAscii;
    }
    public String encode(String plainText){
        String encodedText = "";
        encodedText += this.randomChar;
        for(int i=0; i<plainText.length(); i++){
            int encodedCharIndex= getEncodedCharIndex(plainText.charAt(i));
            if(encodedCharIndex== 99){
                encodedText+= plainText.charAt(i);

            } else {
                int encodedAscii = getEncodedAscii(encodedCharIndex);
                char encodedChar = (char) encodedAscii;
                encodedText += encodedChar;
            }
        }
        return encodedText;
    }
//    public String decode(String encodedText){
//        return "";
//    }
}

