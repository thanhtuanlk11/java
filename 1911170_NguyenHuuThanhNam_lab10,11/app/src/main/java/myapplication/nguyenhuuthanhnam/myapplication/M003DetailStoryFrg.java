package myapplication.nguyenhuuthanhnam.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

public class M003DetailStoryFrg extends Fragment {
    private Context mContext;
    private ArrayList<StoryEntity> listStory;
    private String topicName;
    private StoryEntity currentStory;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m003_frg_detail_story, container, false);
        initViews(rootView);
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
    private void initViews(View v) {
        v.findViewById(R.id.iv_back).setVisibility(View.VISIBLE);
        v.findViewById(R.id.iv_back).setOnClickListener(v1 -> backToM002Screen());
        ((TextView) v.findViewById(R.id.tv_name)).setText(topicName);
        ViewPager vp = v.findViewById(R.id.vp_story);
        DetailStoryAdapter adapter = new DetailStoryAdapter(listStory, mContext);
        vp.setAdapter(adapter);
        vp.setCurrentItem(listStory.indexOf(currentStory), true);
    }
    private void backToM002Screen() {
        ((MainActivity) getActivity()).gotoM002Screen(topicName);
    }
    public void setData(String topicName, ArrayList<StoryEntity> listStory, StoryEntity
            currentStory) {
        this.currentStory = currentStory;
        this.topicName = topicName;
        this.listStory = listStory;
    }
}

