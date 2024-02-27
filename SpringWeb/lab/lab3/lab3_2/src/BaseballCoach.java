public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }



    //define a private field for the dependency
    private FortuneService fortuneService;
    //define a contructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService){
        this.fortuneService=theFortuneService;
    }
    @Override
    public String getDailyFortune() {
        //use my fortuneService to get a fortune
        return fortuneService.getFortune();
    }
}
