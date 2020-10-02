package com.jhw.module.util.bug.core.app;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.module.util.bug.core.domain.Bug;
import com.jhw.module.util.bug.repo.BugRepoImpl;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class BugHandler {

    private static final BugRepo repo = new BugRepoImpl();

    private BugHandler() {
    }

    public static Bug reportBug(Bug bug) {
        try {
            repo.write(bug);
            return bug;
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
        return null;
    }

}
