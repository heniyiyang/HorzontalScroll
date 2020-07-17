package demo.app.lirui.horizontalscroll.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class ImageLoader {

    private static ImageLoader imageLoader;

    private ImageLoader(){}

    private Context context;
    private int errorHead;

    public static ImageLoader getInstance(){
        if (imageLoader == null){
            synchronized (ImageLoader.class){
                imageLoader = new ImageLoader();
            }
        }
        return imageLoader;
    }

    public void setErrorHead(int errorHead){
        this.errorHead = errorHead;
    }

    public void initImageLoader(Context context){
        this.context = context;
    }

    public void bind(String url , ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
    public void bind(String url ,int error,int placeholder,int fallback, ImageView imageView){
        RequestOptions mPreOptions = new RequestOptions()
                .placeholder(placeholder)//加载成功前显示的图片
                .fallback(fallback) //url为空的时候,显示的图片
                .error(error);
        Glide.with(context)
                .load(url)
                .apply(mPreOptions)
                .into(imageView);
    }

    public void bind(String url , ImageView imageView,RequestListener listener){
        Glide.with(context).load(url).listener(listener).into(imageView);
    }

    public void bind(String url ,int error, ImageView imageView){
         RequestOptions mPreOptions = new RequestOptions()
                .skipMemoryCache(true)
                .error(error);
        Glide.with(context).load(url).apply(mPreOptions).into(imageView);
    }

    public void bind(String url ,int placeholder, int error, ImageView imageView){
        RequestOptions mPreOptions = new RequestOptions()
                .skipMemoryCache(true)
                .placeholder(placeholder)
                .error(error);
        Glide.with(context).load(url).apply(mPreOptions).into(imageView);
    }


    //高斯模糊
    public void bindBlur(String url , ImageView imageView){
        Glide.with(context).load(url)
                //设置高斯模糊
                // “23”：设置模糊度(在0.0到25.0之间)，默认”25";"4":图片缩放比例,默认“1”。
                .apply(bitmapTransform(new BlurTransformation(15, 3)))
                .into(imageView);
    }
    public void bind(File file , ImageView imageView){
        Glide.with(context).load(file).into(imageView);
    }
    public void bind(int resource , ImageView imageView){
        Glide.with(context).load(resource).into(imageView);
    }
    public void bind(byte[] image , ImageView imageView){
        Glide.with(context).load(image).into(imageView);
    }

    /**
     * 加载圆角图片
     * @param
     * */
    public  void displayRoundCornerImage(String path,int placeholder,int error,int corners, ImageView galleryImageView) {
        RequestOptions roundOptions = new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(corners));
        roundOptions.skipMemoryCache(true).placeholder(placeholder).error(error);
        Glide.with(context).load(path).apply(roundOptions).into(galleryImageView);
    }

    public void bindCornerHead(String path,int placeholder,int error,ImageView galleryImageView){
        displayRoundCornerImage(path,placeholder,error,10,galleryImageView);
    }

}
