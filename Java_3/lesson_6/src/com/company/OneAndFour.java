package com.company;

public class OneAndFour {



    public boolean check(int arr[]){

        boolean b1 = false;
        boolean b4 = false;

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == 1){
                b1 = true;
            }else if(arr[i] == 4){
                b4 = true;
            }
        }
        if(b1 == true && b4 == true){
            return  true;
        }
        return false;
    }
}
