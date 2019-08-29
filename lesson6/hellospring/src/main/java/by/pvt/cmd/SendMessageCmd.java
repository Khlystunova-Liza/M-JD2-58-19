package by.pvt.cmd;

import by.pvt.service.MessageType;

public class SendMessageCmd {

    public final String receiverName;

    public final MessageType messageType;

    public final String channel;


    public SendMessageCmd(String receiverName, MessageType messageType, String channel) {
        this.receiverName = receiverName;
        this.messageType = messageType;
        this.channel = channel;
    }
}
