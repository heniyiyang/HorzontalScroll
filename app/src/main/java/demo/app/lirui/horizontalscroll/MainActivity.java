package demo.app.lirui.horizontalscroll;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.app.lirui.horizontalscroll.utils.ListUtil;

public class MainActivity extends AppCompatActivity implements ContentAdapter.OnContentScrollListener {

    @BindView(R.id.rv_tab_right)
    RecyclerView rvTabRight;
    @BindView(R.id.hor_scrollview)
    CustomHorizontalScrollView horScrollview;
    @BindView(R.id.ll_top_root)
    LinearLayout llTopRoot;
    @BindView(R.id.recycler_content)
    RecyclerView recyclerContent;
    private List<String> topTabs = new ArrayList<>();
    ContentAdapter contentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //处理顶部标题部分
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvTabRight.setLayoutManager(linearLayoutManager);
        TopTabAdpater topTabAdpater = new TopTabAdpater(this);
        rvTabRight.setAdapter(topTabAdpater);
        for (int i = 0; i < 10; i++) {
            topTabs.add("标题" + (i + 1));
        }
        topTabAdpater.setDatas(topTabs);
        //处理内容部分
        recyclerContent.setLayoutManager(new LinearLayoutManager(this));
        recyclerContent.setHasFixedSize(true);
        contentAdapter = new ContentAdapter(this);
        recyclerContent.setAdapter(contentAdapter);
        contentAdapter.setOnContentScrollListener(this);
        recyclerContent.postDelayed(new Runnable() {
            @Override
            public void run() {
                contentAdapter.setDatas(ListUtil.getData());
                Toast.makeText(MainActivity.this, "加载完毕,加载了10条数据", Toast.LENGTH_SHORT).show();
            }
        }, 1500);

        //滚动RV时,同步所有横向位移的item
        recyclerContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                setScroll(contentAdapter.getOffestX());
            }
        });

        //同步顶部tab的横向scroll和内容页面的横向滚动
        //同步滚动顶部tab和内容
        horScrollview.setOnCustomScrollChangeListener(new CustomHorizontalScrollView.OnCustomScrollChangeListener() {
            @Override
            public void onCustomScrollChange(CustomHorizontalScrollView listener, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                setScroll(scrollX);
            }
        });
    }

    private void setScroll(int scrollx) {
        List<ContentAdapter.ItemViewHolder> viewHolderCacheList = contentAdapter.getViewHolderCacheList();
        if (null != viewHolderCacheList) {
            int size = viewHolderCacheList.size();
            for (int i = 0; i < size; i++) {
                viewHolderCacheList.get(i).horItemScrollview.scrollTo(scrollx, 0);
            }
        }
    }

    @Override
    public void onScroll(int offestX) {
        //处理单个item滚动时,顶部tab需要联动
        if (null != horScrollview) horScrollview.scrollTo(offestX, 0);
    }
}
