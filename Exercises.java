import java.util.*;
// W.P. Iverson code for testing text Exercises
// mystery methods from Chapter 13
// Building Java Programs
//
// copyleft February 2023

public class Exercises {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		Random r = new Random();
		int N = 10000;
		for (int i=0; i<N; i++)
			list.add(Math.abs(r.nextInt()));
		//System.out.println(list);
		
		long time = 0;
		System.out.println(System.currentTimeMillis());
		for (int i=0; i<10; i++){ 
			time = System.currentTimeMillis();
			mystery4(list);		
			System.out.println(System.currentTimeMillis()-time);

		}
	}
	
	public static void mystery4(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i += 2) {
			Integer first = list.get(i);
			list.set(i,  list.get(i + 1));
			list.set(i + 1,  first);
		}
	}
	
}
