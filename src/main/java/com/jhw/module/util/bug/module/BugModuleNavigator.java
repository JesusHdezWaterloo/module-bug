package com.jhw.module.util.bug.module;

import com.clean.core.app.services.NavigationService;
import com.jhw.module.util.bug.ui.BugInputPanel;
import com.jhw.swing.models.input.dialogs.DialogModelInput;

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
                DialogModelInput.from(new BugInputPanel());
                break;
        }
    }

}
