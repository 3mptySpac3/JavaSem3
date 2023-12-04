import java.util.Collections;
import java.util.List;

public class BiSearch {
	public static int binarySearch(List<Student> sortedList, String targetName) {
		int low = 0;
		int high = sortedList.size() - 1;
		
		while (low <= high) {
			int mid = (low + high)/2;
			String midName = sortedList.get(mid).getName();
			
			int comparison = midName.compareTo(targetName);
			
			if (comparison < 0) {
				low = mid + 1;
				
			}else if (comparison > 0) {
				high = mid - 1;
				
			}else {
				return mid;
			}
		}
		return -1; 

	}
	

}
