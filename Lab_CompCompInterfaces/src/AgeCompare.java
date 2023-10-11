import java.util.Comparator;


public class AgeCompare implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		if(student1.getAge() > student2.getAge()) {
			return 1;
		}
		else if (student1.getAge() < student2.getAge()) {
			return -1;
		}
		else {
			return student1.getName().compareTo(student2.getName());
		}
	}
}
