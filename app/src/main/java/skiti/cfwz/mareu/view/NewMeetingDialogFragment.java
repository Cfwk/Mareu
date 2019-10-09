package skiti.cfwz.mareu.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

import skiti.cfwz.mareu.R;
import skiti.cfwz.mareu.controller.DI;
import skiti.cfwz.mareu.controller.MeetingApiService;
import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.model.Salle;

/**
 * Created by Skiti on 21/08/2019
 */

public class NewMeetingDialogFragment extends DialogFragment {


    private Spinner mSalles;
    private EditText mCreator;
    private EditText mSujet;
    private TimePicker mTime;
    private EditText mParticipants;
    private Button mButton;
    private MeetingApiService ApiService;
    private List<Salle> salles;
    private Boolean Creation = true;
    private Meeting NewMeeting;
    private List<String>Participants;

    public interface NewMeetingDialogListener {
        void onFinishEditDialog(String inputText);
    }

    public NewMeetingDialogFragment() {
    }

    public static NewMeetingDialogFragment newInstance(String title) {
        NewMeetingDialogFragment frag = new NewMeetingDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApiService = DI.getMeetingApiService();
        salles = ApiService.getSalles();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dialog_fragment_new_meeting, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        mCreator = (EditText) view.findViewById(R.id.creator);
        mParticipants = (EditText) view.findViewById(R.id.participants);
        mSujet = (EditText) view.findViewById(R.id.sujet);
        mTime = (TimePicker) view.findViewById(R.id.timepicker);
        mSalles = (Spinner) view.findViewById(R.id.salle);
        mButton = (Button) view.findViewById(R.id.newMeeting);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        // Show soft keyboard automatically and request focus to field


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
                if (Creation==true) {
                    ApiService.addMeeting(NewMeeting);
                    dismiss();
                }
            }
        });
        setSpinner();
    }

    private void addData() {
        if (mCreator.getText()!=null&&mSujet.getText()!=null&&mTime!=null&&mParticipants.getText()!=null) {
            String str = mParticipants.getText().toString();
            NewMeeting = new Meeting(
                    mSujet.getText().toString(),
                    ConvertSalle(mSalles.getSelectedItem().toString()),
                    mSujet.getText().toString(),
                    mCreator.getText().toString(),
                    mParticipants.getText().toString(),
                    mTime.getCurrentHour(),
                    mTime.getCurrentMinute());
        }else Creation = false;
    }

    private Salle ConvertSalle(String string) {
        for (int i = 0 ; i<salles.size(); i++)
        {
            System.out.println("tour"+i);
            if (salles.get(i).getName().contentEquals(string)){
                return salles.get(i);
            }
        }
        return null;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    public void setSpinner() {
        List<String> categories = new ArrayList<String>();
        categories.add(salles.get(0).getName().toString());
        categories.add(salles.get(1).getName().toString());
        categories.add(salles.get(2).getName().toString());
        categories.add(salles.get(3).getName().toString());
        categories.add(salles.get(4).getName().toString());
        categories.add(salles.get(5).getName().toString());
        categories.add(salles.get(6).getName().toString());
        categories.add(salles.get(7).getName().toString());
        categories.add(salles.get(8).getName().toString());
        categories.add(salles.get(9).getName().toString());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSalles.setAdapter(dataAdapter);
    }

    @Override
    public void onResume() {
        // Get existing layout params for the window
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        // Assign window properties to fill the parent
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        // Call super onResume after sizing
        super.onResume();
    }

}