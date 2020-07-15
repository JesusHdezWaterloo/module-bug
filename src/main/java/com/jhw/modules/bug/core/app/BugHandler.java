package com.jhw.modules.bug.core.app;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.modules.bug.core.domain.Bug;
import com.jhw.modules.bug.repo.BugRepoImpl;
import com.jhw.utils.jackson.JACKSON;
import java.io.File;
import javax.imageio.ImageIO;

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
            ExceptionHandler.getExceptionHandlerService().handleException(e);
        }
        return null;
    }

}
