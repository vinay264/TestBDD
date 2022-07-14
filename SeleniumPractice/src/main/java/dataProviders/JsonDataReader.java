package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import configs.PersonalDetails;
import managers.FileReaderManager;

public class JsonDataReader {

	private final String personalDetailsJsonPath = FileReaderManager.getInstance().getConfigReader()
			.getPersonalDetailsJsonPath();
	private List<PersonalDetails> customerList;

	public JsonDataReader() {
		customerList = getCustomerData();
	}

	private List<PersonalDetails> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(personalDetailsJsonPath));
			PersonalDetails[] customers = gson.fromJson(bufferReader, PersonalDetails[].class);
			return Arrays.asList(customers);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + personalDetailsJsonPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public final PersonalDetails getCustomerByName(String customerName) {
		return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
	}

}
