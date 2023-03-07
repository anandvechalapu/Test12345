·       Ability to select the date and year from calendar.
·       Ability to select the month from the drop down menu.
·       Date should display as per selection done by the user.
Solution:

Controller Class: 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarController {

    @RequestMapping("/calendar")
    public ModelAndView getCalendarPage() {
        ModelAndView mv = new ModelAndView("calendar");
        return mv;
    }

    @RequestMapping("/select-dates")
    public ModelAndView selectDates(@RequestParam(name="date") String date, 
                                   @RequestParam(name="month") String month, 
                                   @RequestParam(name="year") String year) {
        ModelAndView mv = new ModelAndView("dateselected");
        mv.addObject("date", date);
        mv.addObject("month", month);
        mv.addObject("year", year);
        return mv;
    }

}

Service Class:

import org.springframework.stereotype.Service;

@Service
public class CalendarService {

    public void selectDates(String date, String month, String year) {
        // Call repository to store the selected dates
    }
}

Repository Class: 

import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {

}