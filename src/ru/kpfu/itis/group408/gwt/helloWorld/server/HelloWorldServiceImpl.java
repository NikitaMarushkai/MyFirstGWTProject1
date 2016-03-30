package ru.kpfu.itis.group408.gwt.helloWorld.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.kpfu.itis.group408.gwt.helloWorld.client.HelloWorldService;

public class HelloWorldServiceImpl extends RemoteServiceServlet implements HelloWorldService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}