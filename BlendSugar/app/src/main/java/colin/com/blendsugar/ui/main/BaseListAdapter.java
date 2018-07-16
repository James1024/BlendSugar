package colin.com.blendsugar.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import colin.com.blendsugar.R;

/**
 * @author wanglr
 * @date 2018/7/13
 */
public class BaseListAdapter extends RecyclerView.Adapter{
    private List<String> mList;

    public BaseListAdapter(List<String> list) {
        mList=list;
    }

    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    public BaseListAdapter getAdapter(){
        return this;
    }

    private BaseListAdapter.OnItemClickListener listener;

    public void setOnItemClickListener(BaseListAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base, parent, false);
        BaseListAdapter.ViewHolder holder = new BaseListAdapter.ViewHolder(v);
        holder.mTextView = v.findViewById(R.id.textView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        BaseListAdapter.ViewHolder viewHolder=(BaseListAdapter.ViewHolder)holder;
        viewHolder.mTextView.setText(mList.get(position));
        if(listener!=null){
            viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(v,position);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public ViewHolder(View v) {
            super(v);
        }

    }
}
