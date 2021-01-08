package com.jhw.module.util.bug.repo;

import com.jhw.module.util.bug.core.app.BugRepo;
import com.jhw.module.util.bug.core.domain.Bug;
import com.root101.json.jackson.JACKSON;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class BugRepoImpl implements BugRepo {

    public static final String URL_FOLDER = "bugs" + File.separator;//carpeta de los bugs
    public static final String URL_REPORT = URL_FOLDER + "report" + File.separator;//carpeta para poner el bug con el screenshot

    @Override
    public void write(Bug bug) throws Exception {
        long millis = System.currentTimeMillis();
        new File(URL_REPORT).mkdirs();
        String url = URL_REPORT + millis + File.separator;
        File folder = new File(url);
        folder.mkdirs();

        File foto = new File(folder.getAbsolutePath(), millis + ".png");
        foto.createNewFile();
        ImageIO.write(bug.getScreenShot(), "png", foto);

        url += System.currentTimeMillis() + ".bug";
        JACKSON.write(new File(url), bug);
    }

}
