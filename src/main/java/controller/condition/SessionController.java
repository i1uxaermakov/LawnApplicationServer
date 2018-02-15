package controller.condition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SessionController {
    private static SessionController sessionController;
    private Map<String,AppSession> activeSessions = new HashMap<>();

    static {
        sessionController = new SessionController();
    }

    public static SessionController getSessionController() {
        return sessionController;
    }

    public void addSession(String ss_id, AppSession appSession) {
        activeSessions.put(ss_id, appSession);
    }

    public AppSession get(String ss_id) {
        return activeSessions.get(ss_id);
    }

    public boolean isAuthorised(String ss_id) {
        return activeSessions.containsKey(ss_id);
    }
}
