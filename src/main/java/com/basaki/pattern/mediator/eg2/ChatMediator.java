package com.basaki.pattern.mediator.eg2;

public interface ChatMediator {

    void sendMessage(String msg, User user);

    void addUser(User user);


}
