package lyplayer;

import java.io.*;

public class ScanDir implements FileFilter {
    
    private boolean allowDirectories;

    /**
     * Create a default MP3FileFilter.  The allowDirectories field will 
     * default to false.
     *
     */
    public ScanDir() {
	this( false );
    }

    /**
     * Create an MP3FileFilter.  If allowDirectories is true, then this filter
     * will accept directories as well as mp3 files.  If it is false then
     * only mp3 files will be accepted.
     *
     * @param allowDirectories whether or not to accept directories
     */
    public ScanDir( boolean allowDirectories ) {
	this.allowDirectories = allowDirectories;
    }

    /**
     * Determines whether or not the file is an mp3 file.  If the file is 
     * a directory, whether or not is accepted depends upon the 
     * allowDirectories flag passed to the constructor.
     *
     * @param pathname the file to test
     * @return true if this file or directory should be accepted
     */
    public boolean accept( File pathname ) {
	boolean retval = false;

	if( pathname.isFile() ) {
	    retval = (pathname.getName().lastIndexOf(".mp3") == 
		      pathname.getName().length() - 4);
	}
	else {
	    retval = allowDirectories;
	}

	return retval;
    }

} // MP3FileFilter
