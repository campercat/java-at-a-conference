public class Session {
  private String name;
  private Person facilitator;

  public Session(String name, Person facilitator) {
    this.name = name;
    this.facilitator = facilitator;
  }

  public String getName() {
    return name;
  }

  public Person getFacilitator() {
    return facilitator;
  }
}
