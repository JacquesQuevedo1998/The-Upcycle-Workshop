import java.util.ArrayList;
import java.io.IOException;

public class UpcycleWorkshop {
	private ArrayList<String> Materials;
	private ArrayList<String> Projects;
	
	public UpcycleWorkshop() {
		Materials = new ArrayList<String>();
		Projects = new ArrayList<String>();
	}
	
	public void addMaterial(String material) {
		Materials.add(material);
	}
	
	public void removeMaterial(String material) {
		Materials.remove(material);
	}
	
	public void addProject(String project) {
		Projects.add(project);
	}
	
	public void removeProject(String project) {
		Projects.remove(project);
	}
	
	public void listMaterials() {
		for(String material : Materials) {
			System.out.println(material);
		}
	}
	
	public void listProjects() {
		for(String project : Projects) {
			System.out.println(project);
		}
	}
	
	public void findProjectsWithMaterial(String material) {
		for(String project : Projects) {
			if(project.contains(material)) {
				System.out.println(project);
			}
		}
	}
	
	public void saveToFile(String fileName) {
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write("Materials:");
			bufferedWriter.newLine();
			
			for(String material : Materials) {
				bufferedWriter.write(material);
				bufferedWriter.newLine();
			}
			
			bufferedWriter.write("Projects:");
			bufferedWriter.newLine();
			
			for(String project : Projects) {
				bufferedWriter.write(project);
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
		}
		catch(IOException e) {
			System.out.println("Error saving to " + fileName);
			e.printStackTrace();
		}
	}
	
	public void loadFromFile(String fileName) {
		Materials.clear();
		Projects.clear();
		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while((line = bufferedReader.readLine()) != null) {
				if(line.equals("Materials:")) {
					while((line = bufferedReader.readLine()) != null) {
						if(line.equals("Projects:")) {
							break;
						}
						
						Materials.add(line);
					}
				}
				
				if(line.equals("Projects:")) {
					while((line = bufferedReader.readLine()) != null) {
						Projects.add(line);
					}
				}
			}
			
			bufferedReader.close();
		}
		catch(IOException e) {
			System.out.println("Error loading from " + fileName);
			e.printStackTrace();
		}
	}
}