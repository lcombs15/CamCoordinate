import java.io.File;

public class Main {

	public static void main(String[] args) {
		System.out.println("File list:");
		File f = new File("/home/lucas/");
		
		for(File file: f.listFiles()) {
			System.out.println(file.toString());
		}
		
		
		System.out.println(System.getProperty("os.name").toString());
	}

}