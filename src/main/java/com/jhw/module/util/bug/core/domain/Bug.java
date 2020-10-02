package com.jhw.module.util.bug.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class Bug implements Serializable {

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String bug;
    private String description;

    @JsonIgnore
    private BufferedImage screenShot;

    public Bug() {
    }

    public Bug(String bug, String description, BufferedImage screenShot) {
        this.bug = bug;
        this.description = description;
        this.screenShot = screenShot;
    }

    public String getBug() {
        return bug;
    }

    public void setBug(String bug) {
        this.bug = bug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BufferedImage getScreenShot() {
        return screenShot;
    }

    public void setScreenShot(BufferedImage screenShot) {
        this.screenShot = screenShot;
    }

}
