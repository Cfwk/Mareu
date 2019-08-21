package skiti.cfwz.mareu.model;

import java.util.List;

/**
 * Created by Skiti on 21/08/2019
 */

public interface MeetingApiService {

    List<Meeting> getMeetings();

    void deleteMeetings(Meeting meeting);

    void addMeeting(Meeting meeting);
}
