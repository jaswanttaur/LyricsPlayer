package lyplayer;

public class NoMPEGFramesException extends Exception {
    
    /**
     * Create a NoMPEGFramesException with a default message.
     *
     */
    public NoMPEGFramesException() {
	super("The file specified is not a valid MPEG.");
    }

    /**
     * Create a NoMPEGFramesException with a specified message.
     *
     * @param msg the message for this exception
     */
    public NoMPEGFramesException( String msg ) {
	super( msg );
    }
    
} // NoMPEGFramesException
