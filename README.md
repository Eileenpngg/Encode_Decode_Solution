# Encode_Decode_Solution
Solution for encoder and decoder in java


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

### 1. Find the ascii value of each letter and symbols + Find the difference between the index and the ascii
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
    //create a variable string called encoded text;
    //
    //push random into encoded
    //loop through the plaintext and check the ascii of the character
    //ascii of the character - difference between ascii and index - random's index = encoded char
    //take encoded char and + difference between ascii and index and covert to char, push into encoded
    //return encoded string


   

