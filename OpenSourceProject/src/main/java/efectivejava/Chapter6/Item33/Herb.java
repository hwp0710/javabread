package efectivejava.Chapter6.Item33;

// Using an EnumMap to associate data with an enum - Pages 161-162

import java.util.*;

// Simplistic class representing a culinary herb - Page 161
public class Herb {
	public enum Type {
		ANNUAL, PERENNIAL, BIENNIAL
	}

	private final String name;
	private final Type type;

	Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		Herb[] garden = {
				new Herb("Basil", Type.ANNUAL),
				new Herb("Carroway", Type.BIENNIAL),
				new Herb("Dill", Type.ANNUAL),
				new Herb("Lavendar", Type.PERENNIAL),
				new Herb("Parsley", Type.BIENNIAL),
				new Herb("Rosemary", Type.PERENNIAL)
		};

		// Using an EnumMap to associate data with an enum - Page 162
		Map<Herb.Type, Set<Herb>> herbsByType =
				new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
		for (Herb.Type t : Herb.Type.values())
			herbsByType.put(t, new HashSet<Herb>());
		for (Herb h : garden)
			herbsByType.get(h.type).add(h);
		System.out.println(herbsByType + "\n");

		//Iterator the map
		//Iterator the entry 
		for (Map.Entry<Herb.Type, Set<Herb>> entry : herbsByType.entrySet()) {
			entry.getKey();
			entry.getValue();
			System.out.println("key=" + entry.getKey() + ";value=" + entry.getValue());
		}
		System.out.println("\n");
		//Iterator the key
		for (Herb.Type key : herbsByType.keySet()) {
			System.out.println("key=" + key);
		}
		System.out.println("\n");
		Iterator<Map.Entry<Herb.Type, Set<Herb>>> itr = herbsByType.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Herb.Type, Set<Herb>> entry = itr.next();
			System.out.println("key=" + entry.getKey() + ";value=" + entry.getValue());
		}

	}
}
