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
package com.root101.module.util.bug.ui;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.module.util.bug.core.domain.Bug;
import java.awt.*;
import java.awt.image.BufferedImage;
import com.root101.module.util.bug.core.app.BugHandler;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.components.labels.MaterialLabel;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import com.root101.swing.material.components.textarea.MaterialTextArea;
import com.root101.swing.material.components.textfield.MaterialTextFactory;
import com.root101.swing.material.components.textfield.MaterialTextFieldIcon;
import com.root101.swing.material.standards.MaterialFontRoboto;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.models.input.panels.ModelPanel;
import com.root101.swing.prepared.textarea.MaterialPreparedTextAreaFactory;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class BugInputPanel extends ModelPanel<Bug> {

    private BufferedImage shot;

    public BugInputPanel() {
        super(null);
        try {
            shot = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (Exception e) {
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();
        textFieldBug = MaterialTextFactory.buildIcon();
        textFieldBug.setIcon(MaterialIcons.BUG_REPORT);

        labelHeader = MaterialLabelsFactory.build();
        labelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeader.setText("Reportar BUG");
        labelHeader.setFont(MaterialFontRoboto.BOLD.deriveFont(24f)); // NOI18N

        textFieldBug.setHint("Bug encontrado");
        textFieldBug.setLabel("Bug");

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(labelHeader);
        vlc.add(textFieldBug);
        vlc.add(textAreaDescripcion);
        super.add(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextArea textAreaDescripcion;
    private MaterialTextFieldIcon<String> textFieldBug;
    private MaterialLabel labelHeader;
    // End of variables declaration                   

    @Override
    public Bug getNewModel() {
        String bug = textFieldBug.getObject();
        String desc = textAreaDescripcion.getObject();
        return new Bug(bug, desc, shot);
    }

    @Override
    public Bug onDeleteAction() {
        return null;
    }

    @Override
    public Bug onCreateAction() {
        try {
            Bug bug = getNewModel();
            BugHandler.reportBug(bug);
            return bug;
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    public boolean onCancelAction() {
        return true;
    }

}
