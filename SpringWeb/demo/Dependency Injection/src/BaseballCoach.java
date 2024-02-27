public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
    private FortuneService fortuneService;
    public BaseballCoach(FortuneService theFortuneService){
        fortuneService=theFortuneService;
    }

}


