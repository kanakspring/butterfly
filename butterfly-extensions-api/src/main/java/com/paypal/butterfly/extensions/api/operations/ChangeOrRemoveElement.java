package com.paypal.butterfly.extensions.api.operations;

import com.paypal.butterfly.extensions.api.TransformationOperation;

/**
 * This interface should be implemented by operations that expect to change or modify elements,
 * standardizing in the TO what to do in the absence of the element to be manipulated.
 * </br>
 * Examples of elements to be changed or removed: files, folders, properties in properties files,
 * POM dependencies, POM managed dependencies, POM plugins, POM managed plugins, POM properties, etc,
 *
 * @author facarvalho
 */
public interface ChangeOrRemoveElement<TO extends TransformationOperation> {

    enum IfNotPresent {
        Fail, NoOp, Warn
    }

    /**
     * Fail ({@link com.paypal.butterfly.extensions.api.TOExecutionResult.Type#ERROR})
     * if the element to be changed or removed is not present
     *
     * @return the transformation operation instance
     */
    TO failIfNotPresent();

    /**
     * Warn ({@link com.paypal.butterfly.extensions.api.TOExecutionResult.Type#WARNING})
     * if the element to be changed or removed is not present
     *
     * @return the transformation operation instance
     */
    TO warnIfNotPresent();

    /**
     * Do nothing, not warn neither fail,  ({@link com.paypal.butterfly.extensions.api.TOExecutionResult.Type#NO_OP})
     * if the element to be changed or removed is not present
     *
     * @return the transformation operation instance
     */
    TO noOpIfNotPresent();

}
