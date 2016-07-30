package data;

public class FileType implements Comparable<FileType> {
	private String name;
	private int modification;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getModification() {
		return modification;
	}

	public void setModification(int modification) {
		this.modification = modification;
	}

	@Override
	public int compareTo(FileType o) {
		return o.getModification() - this.getModification();
	}

	public FileType(String name, int modification) {
		super();
		this.name = name;
		this.modification = modification;
	}

	@Override
	public String toString() {
		return "FileType [name=" + name + ", modification=" + modification + "]";
	}

}
