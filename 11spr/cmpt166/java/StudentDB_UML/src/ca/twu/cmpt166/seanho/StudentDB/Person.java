/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ca.twu.cmpt166.seanho.StudentDB;

import javax.mail.Address;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Person#getEmail <em>Email</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Person#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getPerson()
 * @model abstract="true"
 * @generated
 */
public interface Person extends EObject {
    /**
     * Returns the value of the '<em><b>Email</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Email</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Email</em>' attribute.
     * @see #setEmail(Address)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getPerson_Email()
     * @model dataType="ca.twu.cmpt166.seanho.StudentDB.EmailAddress"
     * @generated
     */
    Address getEmail();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Person#getEmail <em>Email</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Email</em>' attribute.
     * @see #getEmail()
     * @generated
     */
    void setEmail(Address value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getPerson_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Person#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // Person
