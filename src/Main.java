import java.io.File;

public class Main {

	public static void main(String[] args) {
		System.out.println("File list:");
		File f = new File("C:\\Users\\Lucas\\Dropbox\\Camera Uploads\\");
		
		for(File file: f.listFiles()) {
			System.out.println(file.toString());
		}
	}

}
