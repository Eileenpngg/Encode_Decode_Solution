# Encode_Decode_Solution
Solution for encoder and decoder in java

## Question 

<img width="580" alt="Screenshot 2023-05-27 at 8 39 39 AM" src="https://github.com/Eileenpngg/Encode_Decode_Solution/assets/77367030/0f85ce76-97ba-4441-ba2c-b3a3e014cf32">


## Psueudocode

### 1. Find the ascii value of each letter and symbols + Find the difference between the index and the ascii
 ```
 (-/ (Index 36-43) (ascii value 40-47) -> difference is 4
 0-9 (Index 26-35) (ascii value 48-57) -> difference is 22
 A-Z (Index 0-25) (ascii value 65-90) -> difference is 65
 a-z return its value or anything outside = char itself
```

### 2. Create an method called random to generate the offset value
```
private Random random = new Random();
    private int randomAscii(){
        boolean randomBool= random.nextBoolean();
        if(randomBool){
            return random.nextInt(91-65)+65;
        }else{
            return random.nextInt(58-40)+40;
        }
    }

```

### 3. Create an method called asciiToIndex to convert a character to index which accepts a character
```
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
```
    
### 4. Create an method called indexToAscii to convert a character index to ascii which accepts a index
```
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
```
## Encoding Psueudocode

### 1. Create a method called encoding which converts the plain text index into encoded character ascii using the indexToAscii method
 ```
   private int encoding(int index, int offset) {
        int newIndex= index-offset;
        if(newIndex< 0){
            newIndex= 44- Math.abs(newIndex);
        }
        return indexToAscii(newIndex);
    }
```
 ### 2. Create a method encode which encodes a plain text and returns the encoded string
 ```
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
```

## Decoding Psueudocode

### 1. Create a method called decoding which converts the encoded character index into decoded character ascii using the indexToAscii method
 ```
   private int decoding(int index,int offset){
        int newIndex= index+offset;
        if(newIndex > 43){
            newIndex= newIndex % 44;
        }
        return indexToAscii(newIndex);
    }
```

 ### 2. Create a method decode which decodes a encoded text and returns the plain text as a string
 ```
   public String decode(String encodedText){
        StringBuilder decodedString = new StringBuilder();

        char charOffSet= encodedText.charAt(0);
        int offset= asciiToIndex(charOffSet);

        for(int i=1; i< encodedText.length();i++){
            char character= encodedText.charAt(i);
            int encodedCharIndex= asciiToIndex(character);
            char newchar= character;
            if (encodedCharIndex!=99){
                newchar = (char) decoding(encodedCharIndex,offset);
            }
            decodedString.append(newchar);
        }
        return decodedString.toString();
    }
}
  
```
