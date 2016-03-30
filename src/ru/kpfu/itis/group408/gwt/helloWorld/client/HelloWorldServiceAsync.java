package ru.kpfu.itis.group408.gwt.helloWorld.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HelloWorldServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
