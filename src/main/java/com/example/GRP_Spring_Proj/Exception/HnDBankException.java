package com.example.GRP_Spring_Proj.Exception;

public class HnDBankException extends Exception{
    String mesg;
    public HnDBankException(String mesg){
        this.mesg = mesg;
    }
    public HnDBankException(){

    }
    public String getMessage(){
        return this.mesg;
    }
}
