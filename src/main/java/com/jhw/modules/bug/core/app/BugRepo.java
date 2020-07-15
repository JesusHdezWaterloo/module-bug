package com.jhw.modules.bug.core.app;

import com.jhw.modules.bug.core.domain.Bug;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface BugRepo {

    public void write(Bug t) throws Exception;

}
