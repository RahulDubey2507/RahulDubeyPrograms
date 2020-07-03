import java.util.Scanner;
import com.tupilabs.human_name_parser.HumanNameParserParser;
import com.tupilabs.human_name_parser.Name;

public class emailformat {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter email address");
		String email = scan.next();
		Name object = new Name("rahul dubey");
		HumanNameParserParser parser = new HumanNameParserParser(object);
		String firstName = parser.getFirst();
		String lastName = parser.getLast();
		String address = email.split("@")[0];
		String pattern = determinePattern(address, firstName, lastName);
		System.out.println(pattern);
		scan.close();
	}

	private static String determinePattern(String name, String firstName, String lastName) {
		String pattern = "COMMON_EMAIL";
		int index1 = 0;
		int index2 = 0;
		if (name.contains(".")) {
			String output1 = name.split("\\.")[0];
			if (output1.equals(firstName)) {
				pattern = "FIRSTDOTLAST";
			} else {
				pattern = "LASTDOTFIRST";
			}
		}
		else if (name.contains("_")) {
			String output1[] = name.split("_");
			if (output1[0].equals(firstName)) {
				pattern = "FIRSTUNDERSCORELAST";
			} else {
				pattern = "LASTUNDERSCOREFIRST";
			}
		}
		else {
			String temp1 = name.replaceAll(firstName, "");
			String temp2 = temp1.replaceAll(lastName, "");
			String temp3 = name.split(temp2)[0];
			if(temp3.equals(firstName)) {
				pattern = "FIRSTCHARLAST";
			}
			else {
				pattern = "LASTCHARFIRST";
			}
		}
		return pattern;
	}
}
