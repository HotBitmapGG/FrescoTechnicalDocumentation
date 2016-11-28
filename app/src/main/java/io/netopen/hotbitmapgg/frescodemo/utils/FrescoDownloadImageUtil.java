package io.netopen.hotbitmapgg.frescodemo.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by hcc on 2016/11/27 17:13
 * 100332338@qq.com
 * <p>
 * 图片下载到本地
 */

public class FrescoDownloadImageUtil
{


    public static File bitmap2File(Bitmap bitmap, String filePath, String fileName)
    {

        File dir = new File(filePath);
        if (!dir.exists())
            dir.mkdir();

        File imageFile = new File(filePath, fileName);
        try
        {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(imageFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return imageFile;
    }


    public void saveFile(File file)
    {

        String path = Environment.getExternalStorageDirectory() + File.separator + "fresco_demo";
    }
}
