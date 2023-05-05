package org.example.Net;


import org.example.Itf.ServerNetSender;
import org.example.Server.GameServer;
import org.example.proto.Mess;
import org.example.proto.MessArray;
import org.example.proto.MessArrayType;
import org.example.proto.MessType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.TreeMap;

public class NetManager extends Thread implements ServerNetSender {
    //private volatile boolean flag = true;
    private MessArray.Builder messesTemp;
    private Mess.Builder messTemp;
    private int id=0;
    private int port=6666;
    private String inputLine;
    private String temp1;
    private String temp2;
    private GameServer server;
    private Thread threadClient;
    private Thread threadServer;
    private TreeMap<Integer,ConnectAttribute> connects;//键为连接的id号,值为连接上一次发来包的时间
    //private ArrayList<Socket> sockets;
    private ServerSocket serverSocket;
    private boolean Contiune=true;
    public int intemp=0;
    private int connectsMax=2;
    private int playCount=0;
    public boolean jixuyunxing=true;//控制所有的匿名类是否继续运行
    private DatagramSocket Insocket;
    private DatagramSocket Outsocket;
    private DatagramPacket InPacket;
    private DatagramPacket OutPacket;
    private int timeOut=0;
    public String intTOMess(int ss){
        temp1="["+ss+"]";
        return temp1;
    }
    //主逻辑
    public NetManager(GameServer server1) throws IOException, InterruptedException {
        {//数值初始化
            id=9999;//服务器默认id
            timeOut=3000;
            port=6666;
            connectsMax=2;//最多有几个连接
            MessPacket.step1=-6;
            ConnectAttribute.TimeOutnum=3000;//设定连接超时的时间
        }
        OutPacket.setPort(port);
        messesTemp=MessArray.newBuilder();
        Insocket =new DatagramSocket(port);
        server=server1;
        server.setManager(this);
        connects=new TreeMap<Integer,ConnectAttribute>();
    }
    public void sendMess(Mess.Builder mess){//封装的协议,服务器和客户端调用的

    }
    public boolean isMessArrayWhole(MessArray.Builder messes){//判断一个messArray是不是整体,是返回true,
        // 当messArray第一个mess是refresh,load或者save时,则这个messArray作为整体行使功能
        return (messes.getMesses(0).getType()==MessType.refresh)||(messes.getMesses(0).getType()==MessType.save)||(messes.getMesses(0).getType()==MessType.load);
    }
    public void internal_sendMessArray(MessArray.Builder messes){//将id相同的mess放入同一个messArray中并发送
        if (isMessArrayWhole(messes)) {//待发送的包是个整体
            int key=messes.getMesses(0).getId();
            for (Mess.Builder mess :messes.getMessesBuilderList()) {
                mess.setId(id);
            }
            OutPacket.setAddress(connects.get(key).getAddress());
            OutPacket.setData(messesTemp.build().toByteArray());
            try {
                Outsocket.send(OutPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {messesTemp.clear();
            for (Integer key : connects.keySet()) {
                for (Mess.Builder mess :messes.getMessesBuilderList()) {
                    if(mess.getId()==key){
                        mess.setId(id);
                        messesTemp.addMesses(mess);
                    }
                }
                OutPacket.setAddress(connects.get(key).getAddress());
                OutPacket.setData(messesTemp.build().toByteArray());
                try {
                    Outsocket.send(OutPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void receiveMesses() {
        System.out.println("AccpetMess from:"+id);
      /*  new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(cz) {
                        time = System.currentTimeMillis(); cz=false;
                    }
                    deltatime=System.currentTimeMillis()-time;
                    if(deltatime>5000){
                        live=false;break;
                    }
                }
            }
        }.start();*/
        try{
            while (true) {
                Insocket.receive(InPacket);
                messesTemp.mergeFrom(InPacket.getData());
                if(isMessArrayWhole(messesTemp))//messArray是一个整体
                {
                    for (Mess mess : messesTemp.getMessesList()) {
                         messTemp= mess.toBuilder();
                    }
                }
                else{//messArray是零碎的
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());

            server.getClientMess(id + "HasloseC:");//断线处理
        }
    }
    public void dealOneMess(Mess.Builder mess){
        if (mess.getType()== MessType.ask_connect)
        {
            set_client_id_set_connect(mess.getId());
        }
        else {
            server.getClientMess(inputLine);
        }
    }
    public int randomId(){
        int out=1000;
        while((out==1000)|(out==id0)|(out==id1)) {
            out = random.nextInt(8997);
            out = out + 1001;
        }
        return out;
    }
    public void set_client_id_set_connect(int id){//建立连接
        boolean t=true;
        //System.out.println("set_id id:"+id);
        for (int i : connects.keySet()) {
            //System.out.println("players has:"+i);

        }
        if(players.size()<playMax){
            int a=randomId();System.out.println("setId:"+a);
            players.add(a);
            return a;
        }else{
            return -1;
        }
    }
    public void MessToClient(String output){
        System.out.println("send2");
        out.println(output);
    }
}

