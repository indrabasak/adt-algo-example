package com.basaki.pattern.chainofcmd;

public interface IHandler {
    void setSuccessor(IHandler successor);

    void handleRequest(Request request);

}
