public class CricketCoach implements Coach{
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
        System.out.println("CriketCoach: inside no-arg contructor");
    }
    public void setFortuneService(FortuneService fortuneService){
        System.out.println("CritcketCoach: inside setter method - setFortuneService");
        this.fortuneService=fortuneService;
    }
}
