package model.condition;

import java.util.HashSet;
import java.util.Set;

public class SessionController {
    private static SessionController sessionControler = new SessionController();
    private Set activeSessions = new HashSet();

    public static SessionController getSessionController() {
        return sessionControler;
    }
}
