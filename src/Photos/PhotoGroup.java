package Photos;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class PhotoGroup {
	
	String destination;
	
	public PhotoGroup(String destination_path){
		this.destination = destination_path;
	}
	
	public static ArrayList<PhotoGroup> searchDirectory(String path, boolean subdirectory) {
		
		//Test directory
				File dir = new File("C:\\Users\\Lucas\\Dropbox\\Camera Uploads\\");
				
				//List files in directory & sort them by date last modified
				File files[] = dir.listFiles();
				Arrays.sort(files,(a, b) -> {
					return (new Date(a.lastModified())).compareTo(new Date(b.lastModified()));
				});
				
				
				Date prev = null;
				int numInGroup = 1;
				//Print everything out
				for(int i = 0; i < files.length; i++) {
					Date current = new Date(files[i].lastModified());
								
					long diffInMilli = -1, diffInMin = -1;
					if(prev != null) {
						diffInMilli = current.getTime() - prev.getTime();
						diffInMin = (diffInMilli / 1000) / 60;
						 if(diffInMin > 15){
								System.out.println();
								numInGroup = 1;
						}else {
							numInGroup++;
						}
					}
					

					System.out.println(numInGroup + ".) " + current + " " + diffInMin + "\t" + files[i]);	
					prev = current;
				}
			}
		
		return new ArrayList<PhotoGroup>();
	}

	private ArrayList<Photo> allPhotosInDirectory(String path, boolean recursiveSearch) {
		ArrayList<Photo> retVal = new ArrayList<Photo>();
		
		File f = new File(path);
		f.isDirectory();
		f.pre
	}
	
	
}
