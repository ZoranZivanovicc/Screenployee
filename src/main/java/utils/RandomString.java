package utils;

import enums.RandomStrings;
import enums.Users;

public class RandomString {
    private String randomString;
    int length;
    StringBuilder sb = new StringBuilder();


    public RandomString(){

    }

    public RandomString(String randomString, int length){
        createRandomString(randomString,length);
    }



    private void createRandomString(String randomStringType, int length ){

        randomString = RandomStrings.valueOf(randomStringType.toUpperCase()).getRandString();
        for (int i =0; i < length;i++){
            int index = (int) (Math.random() * randomString.length());
            sb.append(randomString.charAt(index));
        }
    }


    public  String getRandomString(){
        return sb.toString();
    }



}
