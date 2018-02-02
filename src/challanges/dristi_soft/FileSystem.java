package challanges.dristi_soft;

import java.util.HashMap;

public class FileSystem {
	static class Directory {
		HashMap<String, Directory> subDirs = new HashMap<>();
		String name;

		public Directory(String Name) {
			this.name = Name;
		}
	}

	public static void main(String[] args) {
		Directory root = new Directory("/");
		root.subDirs.put("home", new Directory("home"));
		root.subDirs.put("temp", new Directory("temp"));

		String[] input = { "/home/abc", "/temp/xyz/wvu" };
		for (int i = 0; i < input.length; i++) {
			String[] res = input[i].split("/");
			int count = 0;
			Directory curr = root;
			for (int j = 1; j < res.length; j++) {
				if (curr.subDirs.containsKey(res[j])) {
					curr = curr.subDirs.get(res[j]);
				} else {
					count++;
					curr.subDirs.put(res[j], new Directory(res[j]));
				}
			}
			System.out.println(count);
		}

	}

}
