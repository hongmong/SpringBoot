package com.homon.network;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;

/**
 * Description :
 *
 * @author Homon
 * @version 1.0
 * @date 2021/12/25 16:46
 */
public class P2PServer {
    private static DatagramSocket server;

    static {
        try {
            server = new DatagramSocket(8889);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String,NodeInfo> clientList = new HashMap<>();

    public P2PServer() throws SocketException {
    }

    public static void main(String[] args) {
        System.out.println("Server start...");
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        while (true) {
            try {
                server.receive(packet);
                String receiveData = new String(packet.getData(),0, packet.getLength());
                System.out.println("receive from " + packet.getAddress().getHostAddress() + ":" + packet.getPort() + " with [" + receiveData + "]");
                if(receiveData.startsWith("register") && registerClient(receiveData,packet)) {
//                    String registerId = getRegisterId(receiveData);
//                    String newClientInfo = registerId + ":" + clientList.get(registerId);
//                    String[] newClientInfoSplit = clientList.get(registerId).split(":");
//                    InetAddress newClientAddress = InetAddress.getByName(newClientInfoSplit[0]);
//                    int newClientPort = Integer.parseInt(newClientInfoSplit[1]);
//                    clientList.forEach((key, value) -> {
//                        String[] info = value.split(":");
//                        try {
//                            if(registerId != key) {
//                                sendNodeInfo(newClientInfo,InetAddress.getByName(info[0]),Integer.parseInt(info[1]));
//                                sendNodeInfo(key + ":" + value,newClientAddress,newClientPort);
//                                Thread.sleep(1000);
//                            }
//                        } catch (UnknownHostException | InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    });
                } else if(receiveData.startsWith("reqconnect")) {
                    reqConnect(receiveData);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    private static void sendNodeInfo(String nodeInfo,InetAddress address,int port) {
//        send("node:" +  nodeInfo,address,port);
//    }

    private static void send(String message,String clientId) throws UnknownHostException {
        NodeInfo nodeInfo = clientList.get(clientId);
        byte[] sendBuf = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, InetAddress.getByName(nodeInfo.getAddress()), nodeInfo.getPort());
        try {
            System.out.println("send message to " + nodeInfo.toTransString() + " with [" + message + "]");
            server.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reqConnect(String data) throws UnknownHostException, InterruptedException {
        String[] split = data.split(":");
        String reqClientId = split[1];
        String toNodeId = split[2];
        NodeInfo reqClientInfo = clientList.get(reqClientId);
        NodeInfo toNodeInfo = clientList.get(toNodeId);
        send("preconn:" + reqClientInfo.toTransString(),toNodeId);
        Thread.sleep(1000);
        send("preconnover:" + toNodeInfo.toTransString(),reqClientId);
    }

    private static boolean registerClient(String data,DatagramPacket packet) throws UnknownHostException {
        String registerId = getRegisterId(data);
        if(registerId  == null) {
            return false;
        }
        int clientPort = packet.getPort();
        InetAddress clientAddress = packet.getAddress();
        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.setClientId(registerId);
        nodeInfo.setAddress(clientAddress.getHostAddress());
        nodeInfo.setPort(clientPort);
        clientList.put(registerId,nodeInfo);
        send("register success",registerId);
        return true;
    }

    public static String getRegisterId(String data) {
        return data.split(":")[1];
    }
}
