package controller.condition;

import java.util.HashSet;
import java.util.Set;

public class SessionController {
    private static SessionController sessionController;
    private Set activeSessions = new HashSet();

    static {
        sessionController = new SessionController();
    }

    public static SessionController getSessionController() {
        return sessionController;
    }

    public void addSession(AppSession session) {
        activeSessions.add(session);
    }
}
