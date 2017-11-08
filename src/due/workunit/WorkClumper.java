package due.workunit;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import due.IDueable;

/**
 * Immutable!
 * @author phlaxyr
 *
 */
public class WorkClumper {
	public static IObjective from(List<WorkQuantity>quantities){
		return immute(quantities);
	}
	public static IObjective from(WorkQuantity...quantities) {
		return immute(quantities);
	}
	private static Clump immute(List<WorkQuantity>quantities){
		return new Clump(ImmutableList.copyOf(quantities));
	}
	private static Clump immute(WorkQuantity...quantities){
		return new Clump(ImmutableList.copyOf(quantities));
	}
	//  3 practically exact same declarations
	public static IObjective from(IDueable... dueables) {
		List<WorkQuantity> amounts = new ArrayList<>();
		for (IDueable due : dueables) {
			for (WorkQuantity work : due.getTypes()) {
				amounts.add(work);
			}
		}
		return immute(amounts);
	}
	public static IObjective merge(Clump...composites){
		List<WorkQuantity> temp = new ArrayList<>();
		for(Clump composite : composites) {
			for(WorkQuantity amount : composite.getTypes()) {
				temp.add(amount);
			}
		}
		return immute(temp);
	}
	public static IObjective merge(Iterable<Clump> composites) {
		List<WorkQuantity> temp = new ArrayList<>();
		for(Clump composite : composites) {
			for(WorkQuantity amount : composite.getTypes()) {
				temp.add(amount);
			}
		}
		return immute(temp);
	}
	
	public static class Clump implements IObjective {
		
		/**
		 * Assume that it's fixed size
		 */
		private final ImmutableList<WorkQuantity> works;
		
		
		/**
		 * YAY ImmutableList
		 */
		Clump(ImmutableList<WorkQuantity> works) { 
			this.works = ImmutableList.copyOf(works);
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
				
		public ImmutableList<WorkQuantity> getTypes(){
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
