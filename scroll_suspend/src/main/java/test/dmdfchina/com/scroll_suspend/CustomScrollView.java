package test.dmdfchina.com.scroll_suspend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by mkt on 2018/1/8.
 */

public class CustomScrollView extends ScrollView {
    private OnMyScrollListener onMyScrollListener;
    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public  void registerListener(OnMyScrollListener  onMyScrollListener){
        this.onMyScrollListener=onMyScrollListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onMyScrollListener!=null){
            onMyScrollListener.onMyscroll(l,t);
        }
    }
}
