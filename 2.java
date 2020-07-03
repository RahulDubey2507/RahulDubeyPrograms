import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class 2 {

	public static void main(String[] args) {
		String csvfile = "C:\\Users\\Rahul\\Documents\\Sacramentorealestatetransactions.csv";
		try {
			File input = new File(csvfile);
			 List<Map<String, String>> allrows = new LinkedList<Map<String, String>>();
			    CsvMapper mapper = new CsvMapper();
			    CsvSchema schema = CsvSchema.emptySchema().withHeader();
			    MappingIterator<Map<String, String>> iterator = mapper.reader(Map.class)
			            .with(schema)
			            .readValues(input);
			    while (iterator.hasNext()) {
			    	allrows.add(iterator.next());
			    }
			    for(Map<String, String> row : allrows) {
			    	System.out.println(row.get("price"));
			    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
