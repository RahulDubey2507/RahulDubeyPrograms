import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class 1 {

	public static ArrayList<String> names(File file) {
		ArrayList<String> fileNames = new ArrayList<String>();
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while ((line = br.readLine()) != null) {
				fileNames.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileNames;
	}

	public static void main(String[] args) {
		ArrayList<String> output1 = new ArrayList<String>();
		ArrayList<String> output2 = new ArrayList<String>();
		String fileOne = "C:\\Users\\Rahul\\Documents\\FileOne.txt";
		File file1 = new File(fileOne);
		String fileTwo = "C:\\Users\\Rahul\\Documents\\FileTwo.txt";
		File file2 = new File(fileTwo);
		output1 = names(file1);
		output2 = names(file2);
		for(String fileName : output1) {
			if(!output2.contains(fileName)) {
				System.out.println(fileName);
			}
		}

	}

}
