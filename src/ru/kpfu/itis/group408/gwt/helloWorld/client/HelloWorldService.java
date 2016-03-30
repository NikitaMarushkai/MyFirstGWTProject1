package ru.kpfu.itis.group408.gwt.helloWorld.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("HelloWorldService")
public interface HelloWorldService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use HelloWorldService.App.getInstance() to access static instance of HelloWorldServiceAsync
     */
    public static class App {
        private static HelloWorldServiceAsync ourInstance = GWT.create(HelloWorldService.class);

        public static synchronized HelloWorldServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
