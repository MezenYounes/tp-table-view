package application;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
	private List<Person> importList;
	private List<Person> exportList;
	public DataClass() {
		importList = new ArrayList<Person>();
		importList.add(new Person("Sami","benali","kjdfjkz"));
		importList.add(new Person("alia","bensalah","kjdfjkz"));
		importList.add(new Person("Sami","bensalah","kjdfjkz"));
		exportList = new ArrayList<Person>();
	}
	public List<Person> getImportList() {
		return importList;
	}
	public void setImportList(List<Person> importList) {
		this.importList = importList;
	}
	public List<Person> getExportList() {
		return exportList;
	}
	public void setExportList(List<Person> exportList) {
		this.exportList.addAll(exportList);
		for(Person p:this.exportList)
		{
			System.out.println(p);
		}
	}
	
	

}
