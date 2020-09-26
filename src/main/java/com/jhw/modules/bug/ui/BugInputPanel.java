package com.jhw.modules.bug.ui;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.modules.bug.core.domain.Bug;
import java.awt.*;
import java.awt.image.BufferedImage;
import com.jhw.modules.bug.core.app.BugHandler;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.material.components.textfield.MaterialTextFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFieldIcon;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.input.panels.ModelPanel;
import com.jhw.swing.prepared.textarea.MaterialPreparedTextAreaFactory;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
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
