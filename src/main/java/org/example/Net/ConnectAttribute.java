package org.example.Net;

import java.net.InetAddress;
import java.util.*;

//int最大20,0000,0000
public class ConnectAttribute {
    //boolean rebirth = false;//当其为false则默认收到的序列号之前的序列都确认过了
    int lastGetTime = 0;
    static int TimeOutnum;//连接超时时间
    InetAddress address;
    public InetAddress getAddress() {
        return address;
    }
    public void setAddress(InetAddress address) {
        this.address = address;
    }
    public ConnectAttribute(InetAddress address1) {
        address=address1;
        serialNumCheck = new ArrayList<Integer>();
        for (int a : serialNumCheck) {
            a = 0;
        }
        serialWaitCheck = new TreeMap<Integer, Integer>();
    }
    public void ClearLastTime() {
        lastGetTime = 0;
    }
    public int getLastGetTime(){
        return lastGetTime;
    }
    int currentSerialNum = 0;
    ArrayList<Integer> serialNumCheck;
    TreeMap<Integer,Integer> serialWaitCheck;


    public int GetConnectStatus(){
        if(lastGetTime>TimeOutnum){return -1;}
        for (Map.Entry<Integer,Integer> a : serialWaitCheck.entrySet()) {
            if(a.getValue()>TimeOutnum){
                return a.getValue();
            }
        }
        return 0;
    }
    /*public void disconnect() {
        rebirth = false;
    }

    public void confirmSerialNum(int num) {
        if (rebirth) {
            if (currentSerialNum >= num) {
                //重复确认了,啥也不做
            }
            if (currentSerialNum + 1 == num) {//正好连续,开始补充序列
                serialWaitCheck.remove(num);//把在超时队列的此序列号清除
                while (!serialNumCheck.isEmpty()) {
                    if ((++num) == serialNumCheck.get(0)) {
                        serialNumCheck.remove(0);
                        currentSerialNum = num;
                    }
                }
            }
            if ((currentSerialNum + 1) < num) {//把之前没有确认过的序列号全部加入超时等待队列
                serialWaitCheck.remove(num);//本身已确认
                for (int i = currentSerialNum + 1; i < num; i++) {
                    if (!(serialWaitCheck.containsKey(i) || serialNumCheck.contains(i))) {
                        serialWaitCheck.put(i, 0);
                    }
                }
                if(!serialNumCheck.contains(num)){
                    serialNumCheck.add(num);//插入并排序
                    Collections.sort(serialNumCheck);
                }
            }
            rebirth = true;
        }
        else{//默认num之前的序列号都确认了,重置序列
            currentSerialNum=num;
            serialNumCheck.clear();
            serialWaitCheck.clear();
        }
    }*/
}
