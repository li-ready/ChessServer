package org.example.Net;


import org.example.Itf.ServerNetSender;
import org.example.Server.GameServer;
import org.example.proto.Mess;
import org.example.proto.MessArray;
import org.example.proto.MessArrayType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.TreeMap;

public class NetManager extends Thread implements ServerNetSender {
    //private volatile boolean flag = true;
    private MessArray.Builder messesTemp;
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
    public void internal_sendMessArray(MessArray.Builder messes){//将id相同的mess放入同一个messArray中并发送
        if (messes.getType() == MessArrayType.normal) {//收到的包只是零碎的信息
            messesTemp.clear();
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
        else {
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
    }
    public void run() {
        super.run();
        System.out.println("AccpetMess from:"+id);
        new Thread(){
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
        }.start();
        try{
            while (true) {
                Insocket.receive(InPacket);
                =InPacket.getAddress();
                cz=true;//收到消息了,没掉线计时器重置
                if ("Idsend00".equals(inputLine.substring(4, 12)))
                {
                    id=server.set_client_id_cal(Integer.parseInt(inputLine.substring(0,4)));
                    out.println("Idset000:"+id);
                    if(id==-1){
                        live=false;break;
                    }
                }
                else {
                    server.getClientMess(inputLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
            live=false;
            server.getClientMess(id+"HasloseC:");//断线处理
        } finally {live=false;
        }
    }

    public void MessToClient(String output){
        System.out.println("send2");
        out.println(output);
    }
}

