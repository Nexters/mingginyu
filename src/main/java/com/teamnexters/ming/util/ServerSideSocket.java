package com.teamnexters.ming.util;
import java.net.*;
import java.io.*;

/**
 * Created by limjuhyun on 7/30/16.
 */
public class ServerSideSocket implements Runnable  {
    ServerSocket serverSocket;
    int serverPort = 9080;
    public ServerSideSocket() {
        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while(true) {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                PrintWriter toClient =
                        new PrintWriter(server.getOutputStream(),true);
                BufferedReader fromClient =
                        new BufferedReader(
                                new InputStreamReader(server.getInputStream()));
                String line = fromClient.readLine();
                if(line.length()>=4) {
                    String strSvc = line.substring(0,4);
                    line = line.substring(4);
                    System.out.println(line);
                    System.out.println(strSvc);
                    //식물의 습도
                    if("0001".equals(strSvc)) {
                        String datetime = line.substring(0,15);
                        String humi = line.substring(15);
                        System.out.println("datetime::"+datetime);
                        System.out.println("humi::"+humi);
                    //방안의 온도와 습도
                    } else if("0002".equals(strSvc)) {
                        String datetime = line.substring(0,15);
                        String temp = line.substring(15,19);
                        String humi = line.substring(19);
                        System.out.println("datetime::"+datetime);
                        System.out.println("temp::"+temp);
                        System.out.println("humi::"+humi);

                        //초음파 접근
                    } else if("0003".equals(strSvc)) {
                        if("1".equals(line)) {
                            System.out.println("접근");
                        } else if("2".equals(line)) {
                            System.out.println("멀어짐");
                        }
                    } else {
                        System.out.println("알 수 없는 코드 :"+line);
                    }

                }


                System.out.println("Server received: " + line);
                toClient.println("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
            }
        }
        catch(UnknownHostException ex) {
            ex.printStackTrace();
        }
        catch(SocketTimeoutException ex) {
            System.out.println("클라이언트를 연결해주세요.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
