package dUtils;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class duJSONManager {

	private static duJSONManager instance;
	final private static Gson gson;

	public duJSONManager getInstance() {
		if (instance == null)
			instance = new duJSONManager();
		return instance;
	}

	private duJSONManager() {
		gson = new Gson();
	}

// templates like this are called like
// duJSONManager.getinstance().<T>loadSingle(f)
//	@SuppressWarnings("unchecked")
	private <T> T loadSingle(File f){
		if (f.isFile() && f.getName().matches(".*\\.json")) {
			//System.out.println("Loading "+f.getName());
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (java.io.FileNotFoundException e) {
				System.out.println("ERROR: Trying to read missing json file "+f.getName());
				return null;
			}
			try {
				String s, text = "";
				while ((s = br.readLine()) != null)
					text += s+"\n";
				return (T) gson.fromJson(text, T);
			} catch (java.io.IOException e) {
				System.out.println("ERROR: Error while reading "+f.getName());
			} finally {
			   try {
				   br.close();
				} catch (java.io.IOException e) {
					System.out.println("ERROR: Error closing file "+f.getName());
					return null;
				}
			}
		}
	}

	public <T> T loadSingle(String FileName) {
		File f = new File(FileName);
		return <T>loadSingle(f);
	}

	public <T> ArrayList<T> load(String FolderName) {
		File jsonFolder = new File(FolderName);
		ArrayList<T> arr = new ArrayList<>();
		for (File f: jsonFolder.listFiles()){
			arr.add(<T>loadSingle(f));
		}
		return arr;
	}

	private <T> T saveSingle(File f, T obj) {
		if (f.isFile() && f.getName().matches(".*\\.json")) {
			//System.out.println("Saving "+f.getName());
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			try {
				bw.write(gson.toJson(obj, T);
			} catch (java.io.IOException e) {
				System.out.println("ERROR: Error while writing "+f.getName());
			} finally {
			   try {
				   bw.close();
				} catch (java.io.IOException e) {
					System.out.println("ERROR: Error closing file "+f.getName());
					return null;
				}
			}
		}
	}


}
