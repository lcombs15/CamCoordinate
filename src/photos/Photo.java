/**
 * Photo.java
 * The Photo class is meant to give a wrapper for a Photo's respective File object.
 * The biggest benefit of this class is the compareTo method for Comparable
 */
package photos;

import java.io.File;
import java.util.Date;

public class Photo implements Comparable<Photo> {

	// Store photos location on disk
	private File f;

	public Photo(String path) {
		f = new File(path);
	}

	public Photo(File f) {
		this.f = f;
	}

	public File getFile() {
		return this.f;
	}

	/*
	 * Photo A is considered to be greater than B if Photo A was last modified after
	 * B.
	 */
	@Override
	public int compareTo(Photo p) {
		return (new Date(this.f.lastModified())).compareTo(new Date(p.getFile().lastModified()));
	}

	//Simply returns the photos path
	@Override
	public String toString() {
		return this.f.getPath();
	}
}
