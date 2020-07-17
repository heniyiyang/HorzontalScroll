package demo.app.lirui.horizontalscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * @ProjectName: HorizontalScrollDemo-master-master
 * @Package: demo.app.com.horizontalscrolldemo
 * @ClassName: CustomHorizontalScrollView
 * @Description:
 * @Author: lirui
 * @CreateDate: 2020/4/23 0023
 */
public class CustomHorizontalScrollView extends HorizontalScrollView {
    private OnCustomScrollChangeListener listener;

    public interface OnCustomScrollChangeListener {
        void onCustomScrollChange(CustomHorizontalScrollView listener, int scrollX, int scrollY, int oldScrollX, int oldScrollY);
    }

    public void setOnCustomScrollChangeListener(OnCustomScrollChangeListener listener) {
        this.listener = listener;
    }

    public CustomHorizontalScrollView(Context context) {
        this(context, null);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (null != listener)
            listener.onCustomScrollChange(CustomHorizontalScrollView.this, l, t, oldl, oldt);
    }
}
