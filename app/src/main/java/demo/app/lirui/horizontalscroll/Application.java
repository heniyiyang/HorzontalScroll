package demo.app.lirui.horizontalscroll;

import demo.app.lirui.horizontalscroll.utils.ImageLoader;

/**
 * @ProjectName: HorizontalScrollDemo-master-master
 * @Package: demo.app.com.horizontalscrolldemo
 * @ClassName: Application
 * @Description:
 * @Author: lirui
 * @CreateDate: 2020/4/23 0023
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化图片加载框架
        ImageLoader.getInstance().initImageLoader(getApplicationContext());
        ImageLoader.getInstance().setErrorHead(R.mipmap.icon_head_default);
    }
}
