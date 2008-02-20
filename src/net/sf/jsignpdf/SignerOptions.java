package net.sf.jsignpdf;

import java.io.PrintWriter;

/**
 * Options for PDF signer.
 * @author Josef Cacek
 */
public class SignerOptions {

	protected final ResourceProvider res = ResourceProvider.getInstance();

	protected volatile PrintWriter printWriter;
	protected volatile String ksType;
	protected volatile String ksFile;
	protected volatile char[] ksPasswd;
	protected volatile String keyAlias;
	protected volatile char[] keyPasswd;
	protected volatile String inFile;
	protected volatile String outFile;
	protected volatile String reason;
	protected volatile String location;
	protected volatile SignResultListener listener;
	protected volatile boolean append;

	/**
	 * Logs localized message to PrintWriter
	 * @param aKey message key
	 */
	void log(final String aKey) {
		log(aKey, (String[]) null);
	}

	/**
	 * Logs localized message to PrintWriter
	 * @param aKey message key
	 * @param anArg message parameter
	 */
	void log(final String aKey, final String anArg) {
		log(aKey, anArg==null? null: new String[] {anArg});
	}

	/**
	 * Logs localized message to PrintWriter
	 * @param aKey message key
	 * @param anArgs message parameters
	 */
	void log(final String aKey, final String[] anArgs) {
		if (printWriter!=null) {
			printWriter.println(res.get(aKey, anArgs));
		}
	}

	/**
	 * Fires event listener
	 * @param aResult
	 * @see #getListener()
	 */
	public void fireSignerFinishedEvent(boolean aResult) {
		if (listener != null) {
			listener.signerFinishedEvent(aResult);
		}
	}

	public PrintWriter getPrintWriter() {
		return printWriter;
	}
	public void setPrintWriter(PrintWriter outWriter) {
		this.printWriter = outWriter;
	}
	public String getKsType() {
		return ksType;
	}
	public void setKsType(String ksType) {
		this.ksType = ksType;
	}
	public String getKsFile() {
		return ksFile;
	}
	public void setKsFile(String ksFile) {
		this.ksFile = ksFile;
	}
	public char[] getKsPasswd() {
		return ksPasswd;
	}
	public void setKsPasswd(char[] passwd) {
		this.ksPasswd = passwd;
	}
	public String getInFile() {
		return inFile;
	}
	public void setInFile(String inFile) {
		this.inFile = inFile;
	}
	public String getOutFile() {
		return outFile;
	}
	public void setOutFile(String outFile) {
		this.outFile = outFile;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public SignResultListener getListener() {
		return listener;
	}
	public void setListener(SignResultListener listener) {
		this.listener = listener;
	}
	public char[] getKeyPasswd() {
		return keyPasswd;
	}
	public void setKeyPasswd(char[] keyPasswd) {
		this.keyPasswd = keyPasswd;
	}
	public String getKeyAlias() {
		return keyAlias;
	}
	public void setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
	}
	public boolean isAppend() {
		return append;
	}
	public void setAppend(boolean append) {
		this.append = append;
	}

}
