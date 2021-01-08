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
package com.root101.module.util.bug.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
