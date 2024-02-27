public class CricketCoach implements Coach{
    private String emailAddress;
    private String team;

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    private FortuneService fortuneService;
    public CricketCoach(){
        System.out.println("CricketCoach: inside no-arg contructor");
    }
    public void setFortuneService(FortuneService fortuneService){
        System.out.println("CricketCoach: inside setter method - setFortuneService");
        this.fortuneService=fortuneService;
    }
}
