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
 * @ClassName: RightScrollAdapter
 * @Description:
 * @Author: lirui
 * @CreateDate: 2020/4/23 0023
 */
public class RightScrollAdapter extends RecyclerView.Adapter<RightScrollAdapter.ScrollViewHolder> {


    private Context context;
    private List<String> rightDatas;

    public RightScrollAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<String> rightDatas) {
        this.rightDatas = rightDatas;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ScrollViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_botoom, viewGroup, false);
        return new ScrollViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScrollViewHolder scrollViewHolder, int i) {
        scrollViewHolder.mTvScrollItem.setText(rightDatas.get(i));
    }

    @Override
    public int getItemCount() {
        return null == rightDatas ? 0 : rightDatas.size();
    }

    class ScrollViewHolder extends RecyclerView.ViewHolder {

        TextView mTvScrollItem;

        public ScrollViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvScrollItem = itemView.findViewById(R.id.tv_right_scroll);

        }
    }
}
