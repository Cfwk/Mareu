package skiti.cfwz.mareu.model;

/**
 * Created by Skiti on 22/08/2019
 */

public class NewMeetingEvent {
    /**
     * Meeting to add
     */
    public Meeting meeting;

    /**
     * Constructor.
     * @param meeting
     */
    public NewMeetingEvent(Meeting meeting) {
        this.meeting = meeting;
    }
}
