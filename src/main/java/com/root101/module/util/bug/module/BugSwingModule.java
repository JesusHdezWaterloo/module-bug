/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.util.bug.module;

import com.root101.clean.swing.app.AbstractSwingApplication;
import com.root101.clean.swing.app.DefaultAbstractSwingMainModule;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
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
