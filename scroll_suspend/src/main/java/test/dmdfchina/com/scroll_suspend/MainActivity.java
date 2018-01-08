package test.dmdfchina.com.scroll_suspend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity  implements OnMyScrollListener {

    private CustomScrollView customScrollView;
    private LinearLayout suspend_layout;
    private LinearLayout titleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        customScrollView = (CustomScrollView) findViewById(R.id.myScrollView);
        customScrollView.registerListener(this);
        suspend_layout = (LinearLayout) findViewById(R.id.suspend_layout);
        titleLayout = (LinearLayout) findViewById(R.id.titleLayout);
        /**
        *注册一个回调函数，当在一个视图树中全局布局发生改变或者视图树中的某个视图的可视状态发生改变时调用这个回调函数。
         *参数 listener    将要被添加的回调函数
         *异常 IllegalStateException       如果isAlive() 返回false
        * */
        titleLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                //初始化布局
                onMyscroll(0,0);
            }
        });
    }

    @Override
    public void onMyscroll(int left, int top) {
        /*根据scrollView的滑动距离来检测悬停部分的距离*/
        titleLayout.setTranslationY(Math.max(top,suspend_layout.getTop()));
    }
}
