package skiti.cfwz.mareu.model;

/**
 * Created by Skiti on 22/08/2019
 */

public class NewMeetingEvent {
    /**
     * Meeting to add
     */
    public Meeting mMeeting;

    /**
     * Constructor.
     * @param meeting
     */
    public NewMeetingEvent(Meeting meeting) {
        this.mMeeting = meeting;
    }
}
