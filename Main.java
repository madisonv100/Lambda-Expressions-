package cs143;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	
	
	public static void main(String[] args) {

		ArrayList<Employee> sorted = loadEmployee("NameList.csv");
		
		// created a shuffled version
		ArrayList<Employee> unsorted = new ArrayList<Employee>(sorted);
		//Collections.shuffle(unsorted);		
		
//		Collections.sort(unsorted, new Comparator<Employee>()
//		{
//			@Override 
//			public int compare(Employee first, Employee second){
//				return second.getFirstName().compareTo(first.getFirstName());
//			}
//			});
				
		//Add code to sort the ArrayList
		//Collections.sort(unsorted);	
//Collections.sort(unsorted,(Employee o2, Employee o1)-> o1.getFirstName().compareTo(o2.getFirstName()));
//unsorted.forEach((Employee)-> System.out.println(Employee));

//Collections.sort(unsorted,(Employee o1, Employee o2)->
//{
//
//	if (o1.getTitle().equals(o2.getTitle()))
//	{
//	
//		return o1.getLevel().compareTo(o2.getLevel());
//	}
//
//	return o1.getTitle().compareTo(o2.getTitle());
//}
//);

Collections.sort(unsorted,(Employee o1, Employee o2)->
{

	if (o1.getLastName().equals(o2.getLastName()))
	{
	
		return o1.getFirstName().compareTo(o2.getFirstName());
	}

	return o1.getLastName().compareTo(o2.getLastName());
}
);


unsorted.forEach((Employee)-> System.out.println(Employee));

//		for (int i = 0; i < unsorted.size(); i++) {
//			//comment out to get rid of print out
//			System.out.println(unsorted.get(i));
//		}
	}
	

	
	public static ArrayList<Employee> loadEmployee(String filename)
	{
		
		BufferedReader br = null;
		FileReader fr = null;
		
		 ArrayList<Employee> employees = new  ArrayList<Employee>();
        ArrayList<String> lines = new  ArrayList<String>();
		try {

			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line;
			br = new BufferedReader(new FileReader(filename));

			while ((line = br.readLine()) != null) 
			{
				lines.add(line);				
			}
		
			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

			

			}
			int count = 0;
			for (int i = 0; i < lines.size(); i++) {
				
				String field[] = lines.get(count++).split(","); 
				
				
				employees.add(new Employee(field[0], field[1], field[2], String.format("%010d", i), field[3]));
				count = count % lines.size();
				
			}

		}

		return employees;
	}
	
}
