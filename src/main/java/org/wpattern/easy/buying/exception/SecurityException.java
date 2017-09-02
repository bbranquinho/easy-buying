package org.wpattern.easy.buying.exception;

import static org.wpattern.easy.buying.exception.ExceptionConstants.SERVER_EXCEPTION;

public class SecurityException extends GenericException {

	private static final long serialVersionUID = 201606062325L;

	public SecurityException() {
		super(ExceptionConstants.SECURITY_EXCEPTION);
	}

}
