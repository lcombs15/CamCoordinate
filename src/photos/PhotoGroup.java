/**
 * PhotoGroup.java0
 * 
 * The purpose of this class hasn't been 100% established, yet.
 * I want this class to be a helpful wrapper around a list of Photos.
 * 
 * Currently this class can parse a directory and create groups of photos
 * based on when they were taken.
 * 
 * Functionality could later include:
 * 	-Handling SQL
 * 	-Book keeping for destination directories
 */
package photos;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class PhotoGroup {
	public static final String[] SUPPORTED_FILE_EXTENSIONS = { "PNG", "JPEG", "GIF", "JPG" };
	private ArrayList<Photo> photos = new ArrayList<Photo>();

	String destination;

	public PhotoGroup(String destination_path) {
		this.destination = destination_path;
	}

	public PhotoGroup() {
	}

	public void addPhoto(Photo p) {
		this.photos.add(p);
	}

	public ArrayList<Photo> getPhotos() {
		return this.photos;
	}

	/*
	 * Break up all photos in a given directory into group based on date last
	 * modified
	 */
	public static ArrayList<PhotoGroup> searchDirectory(String path, boolean recursiveSearch) {
		// Get sorted list of photos in directory
		ArrayList<Photo> photos = allPhotosInDirectory(path, recursiveSearch);

		// Do not continue if no photos found
		if (photos.size() == 0)
			return null;

		// Create retVal now that we've found photos
		ArrayList<PhotoGroup> retVal = new ArrayList<PhotoGroup>();

		// Prepare first group by adding first photo
		PhotoGroup current_group = new PhotoGroup();
		current_group.addPhoto(photos.get(0));

		// References to current and previous for loop convenience
		Photo current;
		Photo previous = photos.get(0);

		for (int i = 1; i < photos.size(); i++) {
			current = photos.get(i);

			// Was the current picture take more than 15 minutes after the previous?
			if ((current.getFile().lastModified() - previous.getFile().lastModified()) / 60_000 > 15) {
				// Group is complete, add to return list
				retVal.add(current_group);

				// Create new group
				current_group = new PhotoGroup();
			}
			// Add current photo to current group
			current_group.addPhoto(current);

			// Current becomes previous
			previous = current;
		}
		return retVal;
	}

	/*
	 * Returns all photos in given directory sorted by date last modified.
	 */
	private static ArrayList<Photo> allPhotosInDirectory(String dir_path, boolean recursiveSearch) {
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

		// Sort photos bases on the Photo.compareTo(Photo p) method
		Collections.sort(retVal);

		return retVal;
	}

	public void moveToDir(File dir) {
		// Make sure we have a directory, not a file
		if (dir.isFile()) {
			moveToDir(dir.getParentFile());
			return;
		}

		// Make directory if it doesn't exist
		if (!dir.exists()) {
			dir.mkdir();
		}

		// Loop through all photos
		for (int i = 0; i < this.photos.size(); i++) {
			// Create destination file based on name and destination directory
			File dest_file = new File(dir, photos.get(i).getFile().getName());

			// If successfully moved file, record change in photo array
			if (photos.get(i).getFile().renameTo(dest_file)) {
				photos.set(i, new Photo(dest_file));
			}
		}
	}

}
