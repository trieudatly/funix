public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return null;
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
    private FortuneService fortuneService;
    public CricketCoach(){

    }
    public void setFortuneService(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
}
