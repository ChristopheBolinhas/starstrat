package hearc.ch.starstrat.dataBase.Remplissage;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

import org.apache.http.util.ByteArrayBuffer;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import hearc.ch.starstrat.dataBase.BDD.ImageBDD;
import hearc.ch.starstrat.dataBase.models.Image;

/**
 * Created by Kevin on 06/01/2015.
 */
public class InsertImages
{

    public InsertImages(ImageBDD image,Context context)
    {
        for(int i=1;i<48;i++)
        {
            Image im = new Image();
            try
            {
                URL imageUrl = new URL("hearc/ch/starstrat/dataBase/Remplissage/Images/"+i+".jpg");
                URLConnection ucon = imageUrl.openConnection();

                InputStream is = ucon.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);

                ByteArrayBuffer baf = new ByteArrayBuffer(500);
                int current = 0;
                while ((current = bis.read()) != -1) {
                    baf.append((byte) current);
                }

                byte[] data = baf.toByteArray();

                im.setImage_Texte(data);
                im.setId_Race_Entities(i);
                image.insertImage(im);
            }
            catch(Exception e)
            {
                Toast.makeText(context, ""+e, Toast.LENGTH_LONG).show();
            }


           /* File f = new File(System.getProperty("user.dir"));

            String[] list = f.list();
            for(int j=0;j<list.length;j++)
            {
                Toast.makeText(context, f.list()[j], Toast.LENGTH_LONG).show();
            }*/




        }
    }
}
