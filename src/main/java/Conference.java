import java.util.ArrayList;
import java.util.List;

public class Conference {
  private String name;
  private int maxRegistrants;
  private List<Person> attendees;
  private List<Session> sessions;

  public Conference(String name, int maxRegistrants) {
    this.name = name;
    this.maxRegistrants = maxRegistrants;
    this.attendees = new ArrayList<>();
    this.sessions = new ArrayList<>();
  }
  public String getName() {
    return this.name;
  }

  public int getMaxRegistrants() {
    return this.maxRegistrants;
  }

  public List<Person> getAttendees() {
    return attendees;
  }

  public List<Session> getSessions() {
    return sessions;
  }

  public boolean register(Person person) {
    // compare the email of person to email of all persons in attendees list
    // if no match, add person to list and return true
    // if match, do not add person to list and return false
    boolean noMatch = true;
    if(attendees.size() >= this.maxRegistrants) {
      return false;
    } else {
      if(attendees.size() != 0) {
        for (Person attendee : attendees) {
          if(person.getEmail().equals(attendee.getEmail())) {
            noMatch = false;
            break;
          }
        }
        if(noMatch) {
          attendees.add(person);
          return true;
        } else {
          return false;
        }
      } else {
        attendees.add(person);
        return true;
      }
    }
  }

  public boolean addSession(Session session) {
    sessions.add(session);
    return true;
  }

  public String getSummary() {
    StringBuilder builder = new StringBuilder();
    builder.append(this.name).append("\n");
    builder.append("Number of Attendees: ").append(attendees.size()).append("\n");
    for(Person attendee : attendees) {
      builder.append(attendee.getFirstName()).append(" ").append(attendee.getLastName()).append("\n");
    }
    builder.append("Number of Sessions: ").append(sessions.size()).append("\n");
    for(Session session : sessions) {
      builder.append(session.getName()).append(", facilitated by ").append(session.getFacilitator().getFirstName()).append(" ").append(session.getFacilitator().getLastName());
    }
    if(attendees.size() == this.maxRegistrants) {
      builder.append("Registration is now closed");
    } else {
      builder.append("Registration is still open");
    }

    return builder.toString();
  }
}
