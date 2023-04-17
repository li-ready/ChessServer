package org.example.Net;


import org.example.Server.GameServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
public class ConnectThread extends Thread{
    public boolean live=true;
    private String inputLine;
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private GameServer server;
    public int id=1000;
    private long time;
    private long deltatime;
    boolean cz=true;
    public ConnectThread(BufferedReader in0,PrintWriter out0,Socket socket0,GameServer server1){
        server=server1;
        in=in0;out=out0;socket=socket0;
        inputLine=new String();
    }

}
