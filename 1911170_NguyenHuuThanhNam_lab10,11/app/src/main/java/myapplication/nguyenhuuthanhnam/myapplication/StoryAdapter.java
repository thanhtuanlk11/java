package myapplication.nguyenhuuthanhnam.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryHolder> {
    private final ArrayList<StoryEntity> listStory;
    private final Context mContext;
    public StoryAdapter(ArrayList<StoryEntity> listStory, Context mContext) {
        this.listStory = listStory;
        this.mContext = mContext;
    }
    @Override
    public StoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_story, parent, false);
        return new StoryHolder(view);
    }
    @Override
    public void onBindViewHolder(StoryAdapter.StoryHolder holder, int position) {
        StoryEntity item = listStory.get(position);
        holder.tvName.setTag(item);
        holder.tvName.setText(item.getName());
    }
    @Override
    public int getItemCount() {
        return listStory.size();
    }
    public class StoryHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        public StoryHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_story);
            itemView.setOnClickListener(v -> {
                ((MainActivity)mContext).gotoM003Screen(listStory, (StoryEntity)tvName.getTag());
            });
        }
    }
}