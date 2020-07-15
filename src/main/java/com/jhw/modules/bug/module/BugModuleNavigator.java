package com.jhw.modules.bug.module;

import com.clean.core.app.services.NavigationService;
import com.jhw.modules.bug.core.domain.Bug;
import com.jhw.modules.bug.ui.BugInputPanel;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.utils.interfaces.Update;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class BugModuleNavigator implements NavigationService {

    public static final String BUG_REPORT = "Reportar Bug";
    public static final String NAV_BUG_REPORT = "modulos.bug.reportar";

    @Override
    public void navigateTo(String string, Object... os) {
        switch (string) {
            case NAV_BUG_REPORT:
                new DialogModelInput<Bug>(new Update[]{}, new BugInputPanel());
                break;
        }
    }

}
