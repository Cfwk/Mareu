package skiti.cfwz.mareu.model;

/**
 * Created by Skiti on 22/08/2019
 */

public class DeleteMeetingEvent {
    /**
     * Meeting to delete
     */
    public Meeting mMeeting;

    /**
     * Constructor.
     * @param meeting
     */
    public DeleteMeetingEvent(Meeting meeting) {
        this.mMeeting = meeting;
    }
}
