package skiti.cfwz.mareu.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import skiti.cfwz.mareu.R;
import skiti.cfwz.mareu.model.DeleteMeetingEvent;
import skiti.cfwz.mareu.model.Meeting;

/**
 * Created by Skiti on 22/08/2019
 */

public class ListMeetingRecyclerViewAdapter extends RecyclerView.Adapter<ListMeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;

    public ListMeetingRecyclerViewAdapter(List<Meeting> items) {
        mMeetings = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_meeting, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Meeting meeting = mMeetings.get(position);
        holder.mMeetingName.setText(meeting.getName());
        holder.mDescription.setText(meeting.getDescription());
        Glide.with(holder.mAvatar.getContext())
                .load(meeting.getSalle().getColor())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mAvatar);
        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteMeetingEvent(meeting));
            }
        });
    }


    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_emails)
        public TextView mDescription;
        @BindView(R.id.item_list_name)
        public TextView mMeetingName;
        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;
        @BindView(R.id.item_list_avatar)
        public ImageView mAvatar;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
