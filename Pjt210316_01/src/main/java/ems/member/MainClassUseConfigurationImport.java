package ems.member;

import ems.member.configration.MemberConfig01;
import ems.member.configration.MemberConfig02;
import ems.member.configration.MemberConfig03;
import ems.member.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/*
dkssudgktpdy
안녕하세요
ddddd
*/
public class MainClassUseConfigurationImport {

	public static void main(String[] args) {
		
		String[] sNums = {"H39r8djakndfae32", "H39asdfaelu42o23", "H39iiemamca8w9h4", 
						  "H39lkmn754fghia7", "H39plo865cuy8k92", "H39mnbviiaed89q1", 
						  "H399omjjyv56t3d5", "H39lczaqwg644gj8", "H39ymbcsh74thgh2", 
						  "H39lesvj7544vf89"};
		
		String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion", 
					    "tiger", "pig", "horse", "bird", "deer"};
		
		String[] sPws = {"96539", "94875", "15284", "48765", "28661", 
						"60915", "30028", "29801", "28645", "28465"};
		
		String[] sNames = {"agatha", "barbara", "chris", "doris", "elva", 
						  "fiona", "holly", "jasmin", "lena", "melissa"};
		
		int[] sAges = {19, 22, 20, 27, 19, 21, 19, 25, 22, 24};
		String[] sGenders = {"M", "W", "W", "M", "M", "M", "W", "M", "W", "W"};
		String[] sMajors = {"English Literature", "Korean Language and Literature", 
				"French Language and Literature", "Philosophy", "History", 
				"Law", "Statistics", "Computer", "Economics", "Public Administration"};

//		AnnotationConfigApplicationContext ctx =
//				new AnnotationConfigApplicationContext(MemberConfig01.class, MemberConfig02.class, MemberConfig03.class);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig01.class);
		
		EMSInformationService informationService = ctx.getBean("informationService", EMSInformationService.class);
		informationService.outputEMSInformation();

		StudentRegisterService registerService = ctx.getBean("registerService", StudentRegisterService.class);
		for (int j = 0; j < sNums.length; j++) {
			Student student = new Student(sNums[j], sIds[j], sPws[j], sNames[j], 
					sAges[j], sGenders[j], sMajors[j]);
			registerService.register(student);
		}

		StudentModifyService modifyService  = ctx.getBean("modifyService", StudentModifyService.class);
		modifyService.modify(new Student("H39lesvj7544vf89", "deer", "00000", "melissa", 
				26, "W", "Vocal Music"));

		StudentSelectService selectService = ctx.getBean("selectService", StudentSelectService.class);
		Student modifiedStudent = selectService.select("H39lesvj7544vf89");
		System.out.print("sNum:" + modifiedStudent.getsNum() + "\t");
		System.out.print("|sId:" + modifiedStudent.getsId() + "\t");
		System.out.print("|sPw:" + modifiedStudent.getsPw() + "\t");
		System.out.print("|sName:" + modifiedStudent.getsName() + "\t");
		System.out.print("|sAge:" + modifiedStudent.getsAge() + "\t");
		System.out.print("|sGender:" + modifiedStudent.getsGender() + "\t");
		System.out.print("|sMajor:" + modifiedStudent.getsMajor() + "\n\n");

		StudentAllSelectService allSelectService = ctx.getBean("allSelectService", StudentAllSelectService.class);
		Map<String, Student> allStudent = allSelectService.allSelect();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.print("sNum:" + student.getsNum() + "\t");
			System.out.print("|sId:" + student.getsId() + "\t");
			System.out.print("|sPw:" + student.getsPw() + "\t");
			System.out.print("|sName:" + student.getsName() + "\t");
			System.out.print("|sAge:" + student.getsAge() + "\t");
			System.out.print("|sGender:" + student.getsGender() + "\t");
			System.out.println("|sMajor:" + student.getsMajor() + "\t");
			
		}
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String str = "";
			
			System.out.println("\n==================================================================="
					+ "==============================================================================");
			System.out.println("Select number.");
			System.out.println("1. Check student information");
			System.out.println("2. Exit");
			
			str = scanner.next();
			if(str.equals("2")) {
				System.out.println("Bye~~");
				break;
			} else {
				System.out.println("Please input your class number.");
				
				str = scanner.next();
				Student student = selectService.select(str);
				System.out.print("sNum:" + student.getsNum() + "\t");
				System.out.print("|sId:" + student.getsId() + "\t");
				System.out.print("|sPw:" + student.getsPw() + "\t");
				System.out.print("|sName:" + student.getsName() + "\t");
				System.out.print("|sAge:" + student.getsAge() + "\t");
				System.out.print("|sGender:" + student.getsGender() + "\t");
				System.out.println("|sMajor:" + student.getsMajor() + "\t");
			}
			
		}
		
		ctx.close();
		
	}

}
