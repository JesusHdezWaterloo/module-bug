package com.jhw.modules.bug.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class BugSwingModule implements AbstractSwingMainModule {

    private final BugModuleNavigator navigator = new BugModuleNavigator();

    @Override
    public void register(AbstractSwingApplication app) {
        System.out.println("Creando 'Bug'");
        registerBug(app);
    }

    private void registerBug(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();
        dash.addKeyValue(DashboardConstants.UP_ELEMENT,
                new AbstractAction(BugModuleNavigator.BUG_REPORT,
                        MaterialIcons.BUG_REPORT.deriveIcon(MaterialColors.WHITE)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo(BugModuleNavigator.NAV_BUG_REPORT);
            }
        });
    }

    /**
     * Dont need navigation
     *
     * @param string
     * @param o
     */
    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
