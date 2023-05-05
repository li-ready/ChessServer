package org.example.Net;

import org.example.proto.Mess;
import org.example.proto.MessArray;
import org.example.proto.MessType;

public class MessPacket {
    static int step1=0;
    //int isArray;
    MessArray.Builder messArray;
    Mess.Builder mess;
    int retry;
    public MessPacket(){
        messArray=null;mess=null;
        retry=0;isArray=0;
    }
    public void Initial(MessArray.Builder messArray1){
        isArray=1;//处理的是mess集
        messArray=messArray1;
    }
    public void Initial(Mess.Builder mess1){
        isArray=0;//处理的是一个mess
        mess=mess1;
    }
     public void setStep1(){
        retry=step1;
    }
    public void AddRetry(){
        retry++;
    }
    public int getRetry(){
        return retry;
    }
    public void DealTimeOut(){
        MessType type;
        if(isArray==1){
            type = messArray.getMesses(0).getType();
        }
        else {
            type=mess.getType();
        }
        switch (type){
            case :break;
        }
    }
}
