import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {
   @Autowired
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("TennisCoach: inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println("TennisCoach: inside setFortuneService() method");
//        this.fortuneService = fortuneService;
//    }

    //define my init method
//@PostConstruct
     public void doMyStartupStuff(){
        System.out.println("TennisCoach: inside of doMyStartupStuff()");
    }

    //define my destroy method
//@PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("TennisCoach: inside of doMyCleanupStuff()");
    }
}
