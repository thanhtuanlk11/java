package myapplication.nguyenhuuthanhnam.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class M002StoryFrg extends Fragment {
    private Context mContext;
    private ArrayList<StoryEntity> listStory;
    private String topicName;
    private StoryEntity currentStory;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m002_frg_story, container, false);
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
        v.findViewById(R.id.iv_back).setOnClickListener(v1 -> backToM001Screen());
        ((TextView) v.findViewById(R.id.tv_name)).setText(topicName);
        RecyclerView rv = v.findViewById(R.id.rv_story);
        ArrayList<StoryEntity> listStory = readStory();
        StoryAdapter adapter = new StoryAdapter(listStory,mContext);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
    }
    private ArrayList<StoryEntity> readStory() {
        ArrayList<StoryEntity> listStory = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("story/"+topicName+".txt"), "UTF-8"));
            String mLine = "";
            do {
                String title = reader.readLine();
                if (title == null) break;
                String content = "";
                do {
                    mLine = reader.readLine();
                    content += mLine + "\n";
                } while (!mLine.contains("','0');"));
                content = content.replace("','0');","");
                StoryEntity storyEntity = new StoryEntity(topicName, title, content);
                listStory.add(storyEntity);
            } while (mLine != null);
        } catch (IOException e) {
        }
        return listStory;
    }
    public void setTopicName(String topicName){
        this.topicName = topicName;
    }
    private void backToM001Screen() {
        ((MainActivity) getActivity()).backToM001Screen();
    }
}

