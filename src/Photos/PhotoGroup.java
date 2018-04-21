package Photos;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class PhotoGroup {

	public static final String[] SUPPORTED_FILE_EXTENSIONS = { "PNG", "JPEG", "GIF" };

	String destination;

	public PhotoGroup(String destination_path) {
		this.destination = destination_path;
	}

	public static ArrayList<PhotoGroup> searchDirectory(String path, boolean subdirectory) {

		// Test directory
		File dir = new File("C:\\Users\\Lucas\\Dropbox\\Camera Uploads\\");

		// List files in directory & sort them by date last modified
		File files[] = dir.listFiles();
		Arrays.sort(files, (a, b) -> {
			return (new Date(a.lastModified())).compareTo(new Date(b.lastModified()));
		});

		Date prev = null;
		int numInGroup = 1;
		// Print everything out
		for (int i = 0; i < files.length; i++) {
			Date current = new Date(files[i].lastModified());

			long diffInMilli = -1, diffInMin = -1;
			if (prev != null) {
				diffInMilli = current.getTime() - prev.getTime();
				diffInMin = (diffInMilli / 1000) / 60;
				if (diffInMin > 15) {
					System.out.println();
					numInGroup = 1;
				} else {
					numInGroup++;
				}
			}

			System.out.println(numInGroup + ".) " + current + " " + diffInMin + "\t" + files[i]);
			prev = current;
		}
		return new ArrayList<PhotoGroup>();
	}

	private ArrayList<Photo> allPhotosInDirectory(String dir_path, boolean recursiveSearch) {
		ArrayList<Photo> retVal = new ArrayList<Photo>();

		File dir = new File(dir_path);

		/*
		 * If we're given a file path rather than a directory path, search the
		 * containing directory instead
		 */
		if (!dir.isDirectory()) {
			return allPhotosInDirectory(dir.getParent(), recursiveSearch);
		}

		// Loop through everything in given directory
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				// Add all Photos found in sub-directory to result
				if (recursiveSearch)
					retVal.addAll(allPhotosInDirectory(f.getPath(), recursiveSearch));
			} else {
				// Make sure the file extension is supported
				for (int i = 0; i < SUPPORTED_FILE_EXTENSIONS.length; i++) {

					// File extension matches
					if (f.getName().toUpperCase().endsWith("." + SUPPORTED_FILE_EXTENSIONS[i]))
						retVal.add(new Photo(f));
				}
			}
		}
		return retVal;
	}

}
