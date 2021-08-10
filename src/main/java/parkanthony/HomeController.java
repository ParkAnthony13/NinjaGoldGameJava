package parkanthony;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	int totalGold = 0;
	
	@RequestMapping("/")
	public String home(Model model,HttpSession session) {
		ArrayList<String> log = new ArrayList<String>();
		if (session.getAttribute("totalGold")==null) {
			session.setAttribute("totalGold", totalGold);
		}
		if (session.getAttribute("loggers")==null) {
			session.setAttribute("loggers", log);
		}
		int currentGold = (int) session.getAttribute("totalGold");
		model.addAttribute("goldCount",currentGold);
		
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("loggers");
		model.addAttribute("loglist", list);
		
		
		return "index.jsp";
	}
	
	
	@RequestMapping(value="/farm", method=RequestMethod.POST)
	public String farming(HttpSession session) {
		System.out.println("farm");
		int find = randomGold("farm");
		session.setAttribute("totalGold", (int) session.getAttribute("totalGold")+find);
		String result = "You entered a farm and earned "+find+" gold "+time();
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("loggers");
		list.add(result);
		return "redirect:/";
	}
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String caving(HttpSession session) {
		System.out.println("cave");
		int find = randomGold("cave");
		session.setAttribute("totalGold", (int) session.getAttribute("totalGold")+find);
		String result = "You entered a cave and earned "+find+" gold "+time();
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("loggers");
		list.add(result);
		return "redirect:/";
	}
	
	
	
	
	
	public int randomGold(String location) {
		Random rand = new Random();
		int gold = 0;
		if (location.equals("farm")) {
			gold = rand.nextInt(11)+10;
		} else if (location.equals("cave")) {
			gold = rand.nextInt(6)+5;
		}
		return gold;
	}
	public String time() {
		LocalDateTime dateNow = LocalDateTime.now();
		DateTimeFormatter nowFormat = DateTimeFormatter.ofPattern("(MMMM d, yyyy H:m a)");
		String now = nowFormat.format(dateNow);
		return now;
	}
}
