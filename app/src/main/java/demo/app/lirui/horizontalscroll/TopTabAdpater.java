package demo.app.lirui.horizontalscroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @ProjectName: HorizontalScrollDemo-master-master
 * @Package: demo.app.com.horizontalscrolldemo
 * @ClassName: TopTabAdpater
 * @Description:
 * @Author: lirui
 * @CreateDate: 2020/4/23 0023
 */
public class TopTabAdpater extends RecyclerView.Adapter<TopTabAdpater.TabViewHolder> {


    private Context context;
    private List<String> datas;

    public TopTabAdpater(Context context) {
        this.context = context;
    }


    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_scroll, viewGroup, false);
        return new TabViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabViewHolder tabViewHolder, int i) {
        tabViewHolder.mTabTv.setText(datas.get(i));
        if(i==0){
            tabViewHolder.v_bottom.setVisibility(View.VISIBLE);
        }else {
            tabViewHolder.v_bottom.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return null == datas ? 0 : datas.size();
    }

    class TabViewHolder extends RecyclerView.ViewHolder {

        TextView mTabTv;
        View v_bottom;
        public TabViewHolder(@NonNull View itemView) {
            super(itemView);
            mTabTv = itemView.findViewById(R.id.tv_right_scroll);
            v_bottom = itemView.findViewById(R.id.v_bottom);
        }
    }

}
