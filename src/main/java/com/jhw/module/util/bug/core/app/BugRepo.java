package com.jhw.module.util.bug.core.app;

import com.jhw.module.util.bug.core.domain.Bug;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface BugRepo {

    public void write(Bug t) throws Exception;

}
