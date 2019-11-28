package skiti.cfwz.mareu.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import skiti.cfwz.mareu.R;
import skiti.cfwz.mareu.model.DeleteMeetingEvent;
import skiti.cfwz.mareu.model.FilterMeetingEvent;
import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.model.ResetMeetingEvent;
import skiti.cfwz.mareu.service.DI;
import skiti.cfwz.mareu.service.MeetingApiService;
import skiti.cfwz.mareu.view.ListMeetingRecyclerViewAdapter;

public class MeetingFragment extends Fragment {
    private MeetingApiService apiService;
    private List<Meeting> meetings;
    private RecyclerView recyclerView;

    public static MeetingFragment newInstance() {
        MeetingFragment fragment = new MeetingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = DI.getMeetingApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_list, container, false);
        Context context = view.getContext();
        recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        initList();
        return view;
    }

    private void initList() {
        meetings = apiService.getMeetings();
        recyclerView.setAdapter(new ListMeetingRecyclerViewAdapter(meetings));
    }

    @Override
    public void onStart() {
        super.onStart();
        initList();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onDeleteMeeting(DeleteMeetingEvent event) {
        apiService.deleteMeetings(event.meeting);
        initList();
    }
    @Subscribe
    public void onResetMeeting(ResetMeetingEvent event) {
        apiService.resetFilter();
        initList();
    }
    @Subscribe
    public void onFilterMeeting(FilterMeetingEvent event){
        initList();
    }
}
