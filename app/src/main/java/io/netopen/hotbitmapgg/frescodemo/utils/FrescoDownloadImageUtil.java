package io.netopen.hotbitmapgg.frescodemo.utils;

/**
 * Created by hcc on 2016/11/27 17:13
 * 100332338@qq.com
 * <p>
 * 保存图片到本地
 */

public class FrescoDownloadImageUtil
{

    // public static final String TAG = FrescoDownloadImageUtil.class.getName();
    //
    //
    // /**
    //  * 判断图片是否存在
    //  *
    //  * @param uri
    //  * @return
    //  */
    // public static boolean isCached(Uri uri)
    // {
    //
    //     ImagePipeline imagePipeline = Fresco.getImagePipeline();
    //     DataSource<Boolean> inDiskCache = imagePipeline.isInDiskCache(uri);
    //     if (inDiskCache == null)
    //         return false;
    //
    //     ImageRequest imageRequest = ImageRequest.fromUri(uri);
    //     CacheKey encodedCacheKey = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(imageRequest);
    //     BinaryResource resource = ImagePipelineFactory.getInstance().getMainDiskStorageCache().getResource(encodedCacheKey);
    //
    //     return resource != null && inDiskCache.getResult() != null && inDiskCache.getResult();
    // }
    //
    //
    // /**
    //  * 获取本地缓存文件
    //  *
    //  * @param uri
    //  * @return
    //  */
    // public static File getCache(Uri uri)
    // {
    //
    //     if (!isCached(uri))
    //         return null;
    //
    //     ImageRequest imageRequest = ImageRequest.fromUri(uri);
    //     CacheKey encodedCacheKey = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(imageRequest);
    //     BinaryResource resource = ImagePipelineFactory.getInstance().getMainDiskStorageCache().getResource(encodedCacheKey);
    //     File file = ((FileBinaryResource) resource).getFile();
    //     return file;
    // }
    //
    //
    // public static void saveFile(Context context, Uri uri)
    // {
    //
    //     File cacheFile = getCache(uri);
    //     String path = Environment.getExternalStorageDirectory() + File.separator + "fersco";
    //     File dir = new File(path);
    //     if (!dir.exists())
    //         dir.mkdir();
    //
    //     String fileName = SystemClock.currentThreadTimeMillis() + ".jpg";
    //     File file = new File(dir, fileName);
    //     try
    //     {
    //         assert cacheFile != null;
    //         FileInputStream fileInputStream = new FileInputStream(cacheFile.getAbsolutePath());
    //         int line = 0;
    //         byte[] buff = new byte[1024];
    //         FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
    //         while ((line = fileInputStream.read(buff)) != -1)
    //         {
    //             fileOutputStream.write(buff, 0, line);
    //         }
    //         fileInputStream.close();
    //         fileOutputStream.close();
    //
    //         Toast.makeText(context, " 图片保存成功", Toast.LENGTH_SHORT).show();
    //     } catch (IOException e)
    //     {
    //         e.printStackTrace();
    //         Toast.makeText(context, " 图片保存失败", Toast.LENGTH_SHORT).show();
    //     }
    //
    //     //发送广播通知图库更新
    //     Uri url = Uri.fromFile(file);
    //     Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, url);
    //     context.sendBroadcast(intent);
    // }
}
