package due.workunit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import due.IDueable;

public class WorkClumper {
	public static IObjective from(IDueable... dueables) {
			List<WorkQuantity> amounts = new ArrayList<>();
			for(IDueable due: dueables) {
				for(WorkQuantity work : due.getTypes()) {
					amounts.add(work);
				}
			}
			return new Clump(amounts);
		
	}
	public static IObjective merge(Clump...composites){
		List<WorkQuantity> temp = new ArrayList<>();
		for(Clump composite : composites) {
			for(WorkQuantity amount : composite.getTypes()) {
				temp.add(amount);
			}
		}
		return new Clump(temp);
	}
	public static IObjective merge(Iterable<Clump> composites) {
		List<WorkQuantity> temp = new ArrayList<>();
		for(Clump composite : composites) {
			for(WorkQuantity amount : composite.getTypes()) {
				temp.add(amount);
			}
		}
		return new Clump(temp);
	}
	public static IObjective from(List<WorkQuantity>quantities){
		return new Clump(quantities);
	}
	public static IObjective from(WorkQuantity...quantities) {
		return new Clump(Collections.unmodifiableList(Arrays.asList(quantities)));
	}
	static WorkQuantity[] toArray(List<WorkQuantity> list) {
		return list.toArray(new WorkQuantity[list.size()]);
	}
	public static class Clump implements IObjective {
		
		/**
		 * Assume that it's fixed size
		 */
		private final List<WorkQuantity> works;
		
		
		/**
		 * Use WorkMultiFactory
		 * @param works
		 */
		Clump(List<WorkQuantity> works) { 
			this.works = Collections.unmodifiableList(works);
		}
		/*
		public WorkMulti(IDueable... dues) {
			List<WorkQuantity> amounts = new ArrayList<>();
			for(IDueable due: dues) {
				for(WorkQuantity work : due.getTypes()) {
					amounts.add(work);
				}
			}
			works = toArray(amounts);
		}*/
				
		public List<WorkQuantity> getTypes(){
			return works;
		}
		public double quantityOf(WorkType type){
			double total = 0;
			for(WorkQuantity w : works) {
				if(w.type().equals(type)) {
					total += w.quantity();
				}
			}
			return total;
		}
	}
}
