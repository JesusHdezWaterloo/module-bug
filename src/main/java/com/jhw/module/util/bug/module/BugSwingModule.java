package com.jhw.module.util.bug.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class BugSwingModule extends DefaultAbstractSwingMainModule {

    private final BugModuleNavigator navigator = new BugModuleNavigator();

    private BugSwingModule() {
    }

    public static BugSwingModule init() {
        System.out.println("Iniciando 'Bug'");
        return new BugSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
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
