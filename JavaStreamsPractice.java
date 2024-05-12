import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers =Arrays.asList(3,2,2,7,5,4,9,7);
		//Intermediate Methods filter(),map(),sorted().distinct(),limit()
		//distinct() will gives unique entries //Limit() will restrict number of results and discard remaining
		numbers.stream().distinct().sorted().limit(3).forEach(s->System.out.println(s));
		
		//filter() filter data as per condition //map() will perform manipulative operations on data
		Stream.of("Anita","Kavita","Priyanka","Aditya").filter(s->s.startsWith("A")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
		//Terminal methods Foreach(), count(), collect()
		List<String> names = Arrays.asList("Anita","Ram","Priyanka","Aditya","Laxman");
		List<String> namesEndWithA = names.stream().filter(s->s.endsWith("a")).collect(Collectors.toList());
		namesEndWithA.stream().forEach(s->System.out.println(s));
		long namesStsrtsWithACount = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(namesStsrtsWithACount);
	}

}
