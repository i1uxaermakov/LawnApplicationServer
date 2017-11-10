package model.condition;

import java.util.HashSet;
import java.util.Set;

public class SessionControler {
    private static SessionControler sessionControler = new SessionControler();
    private Set activeSessions = new HashSet();

    public static SessionControler getSessionControler() {
        return sessionControler;
    }
}
