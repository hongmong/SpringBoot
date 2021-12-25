package com.homon.network;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;

/**
 * Description :
 *
 * @author Homon
 * @version 1.0
 * @date 2021/12/25 17:39
 */
public class P2PClient {

    public static String host = "127.0.0.1";
    public static String clientId = "1";
    public static int port = 8889;
    private static DatagramSocket client;

    private static HashMap<String,NodeInfo> nodeList = new HashMap<>();


    static {
        try {
            client = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(args[0]);
        clientId = args[0];
        try {
            register();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        while (true) {
            try {
                String  receiveData = receive();
                if(receiveData.startsWith("node")) {
                    NodeInfo nodeInfo = new NodeInfo(receiveData);
                    nodeList.put(nodeInfo.getClientId(),nodeInfo);
                } else if(receiveData.startsWith("preconnover")) {
                    NodeInfo nodeInfo = new NodeInfo(receiveData.substring(receiveData.indexOf(":") + 1));
                    send(clientId + " connection " + nodeInfo.getClientId(), InetAddress.getByName(nodeInfo.getAddress()),nodeInfo.getPort());

                } else if(receiveData.startsWith("preconn")) {
                    NodeInfo nodeInfo = new NodeInfo(receiveData.substring(receiveData.indexOf(":") + 1));
                    send(clientId + " preconnection " + nodeInfo.getClientId(), InetAddress.getByName(nodeInfo.getAddress()),nodeInfo.getPort());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void send(String message,InetAddress inetAddress,int port) throws IOException {
        byte[] bytes = message.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAddress,port);
        client.send(packet);
    }

    public static void register() throws IOException {
        SocketAddress target = new InetSocketAddress(host, port);
        String message = "register:" + clientId;
        byte[] sendBuf = message.getBytes();
        DatagramPacket pack = new DatagramPacket(sendBuf, sendBuf.length, target);
        client.send(pack);
    }

    public static String receive() throws IOException {
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        client.receive(packet);
        String receiveData = new String(packet.getData(),0,packet.getLength());
        System.out.println("receive from " + packet.getAddress().getHostAddress() + ":" + packet.getPort() + " with : [" + receiveData+"]");
        return receiveData;
    }
}
