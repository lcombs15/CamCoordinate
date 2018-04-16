package Photos;
import java.io.File;
import java.util.Date;

public class Photo implements Comparable<Photo>{
	
	private File f;
	
	public Photo(String path) {
		f = new File(path);
	}
	
	public File getFile() {
		return this.f;
	}

	@Override
	public int compareTo(Photo p) {
		return (new Date(this.f.lastModified())).compareTo(new Date(p.getFile().lastModified()));
	}	
}
