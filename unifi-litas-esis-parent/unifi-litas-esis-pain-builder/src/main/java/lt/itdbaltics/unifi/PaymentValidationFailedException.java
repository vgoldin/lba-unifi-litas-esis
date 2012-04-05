package lt.itdbaltics.unifi;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class PaymentValidationFailedException extends RuntimeException {
	private static final long serialVersionUID = 5644556966336245518L;
	private final Set<ConstraintViolation<Object>> constraintViolations;
	private final String objectId;
	
	public PaymentValidationFailedException(String objectId, Set<ConstraintViolation<Object>> constraintViolations) {
		this.objectId = objectId;
		this.constraintViolations = constraintViolations;
	}

	@Override
	public String getMessage() {
		StringBuilder buffer = new StringBuilder("Validation failed for: ");
		buffer.append("object Id: ");
		buffer.append(objectId);

		buffer.append("; errors: [");
		for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
			buffer.append("property: " + constraintViolation.getPropertyPath() + "; value: " + constraintViolation.getInvalidValue() + "; constraint: "
					+ constraintViolation.getMessage() + "; ");
		}
		
		buffer.append("]");

		return buffer.toString();
	}
}
