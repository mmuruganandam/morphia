package com.google.code.morphia.mapping.validation.classrules;


import java.util.Set;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.mapping.MappedClass;
import com.google.code.morphia.mapping.Mapper;
import com.google.code.morphia.mapping.validation.ClassConstraint;
import com.google.code.morphia.mapping.validation.ConstraintViolation;
import com.google.code.morphia.mapping.validation.ConstraintViolation.Level;


/**
 * @author Uwe Schaefer, (us@thomas-daily.de)
 */
public class EmbeddedAndValue implements ClassConstraint {

  public void check(final MappedClass mc, final Set<ConstraintViolation> ve) {

    if (mc.getEmbeddedAnnotation() != null && !mc.getEmbeddedAnnotation().value().equals(Mapper.IGNORED_FIELDNAME)) {
      ve.add(new ConstraintViolation(Level.FATAL, mc, getClass(),
        "@" + Embedded.class.getSimpleName() + " classes cannot specify a fieldName value(); this is on applicable on fields"));
    }
  }

}
