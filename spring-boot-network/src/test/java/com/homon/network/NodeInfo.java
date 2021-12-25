package com.homon.network;

/**
 * Description :
 *
 * @author Homon
 * @version 1.0
 * @date 2021/12/25 17:58
 */
public class NodeInfo {

    private String address;

    private int port;

    private String clientId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String toTransString() {
        return this.clientId + ":" + this.address + ":" + this.port;
    }

    public NodeInfo() {

    }
    public NodeInfo(String transString) {
        String[] split = transString.split(":");
        this.clientId = split[0];
        this.address = split[1];
        this.port = Integer.parseInt(split[2]);
    }
}
