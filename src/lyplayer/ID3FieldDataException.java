package lyplayer;

public class ID3FieldDataException extends Exception {
    
    /**
     * Create an ID3FieldDataException with a default message
     *
     */
    public ID3FieldDataException() {
	super( "Invalid data supplied to ID3 tag." );
    }

    /**
     * Create an ID3FieldDataException with the specified message
     *
     * @param msg a String specifying the specific problem encountered
     */
    public ID3FieldDataException( String msg ) {
	super( msg );
    }
    
} // ID3FieldDataException
