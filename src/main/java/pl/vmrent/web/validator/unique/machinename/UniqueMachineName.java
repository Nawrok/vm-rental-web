package pl.vmrent.web.validator.unique.machinename;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueMachineNameValidator.class)
public @interface UniqueMachineName
{
    String message() default "{unique.machinename.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
