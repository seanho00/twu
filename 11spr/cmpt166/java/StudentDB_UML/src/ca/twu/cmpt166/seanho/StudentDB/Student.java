/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ca.twu.cmpt166.seanho.StudentDB;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Student</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Student#getID <em>ID</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Student#getGPA <em>GPA</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Student#getEnrolledIn <em>Enrolled In</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getStudent()
 * @model
 * @generated
 */
public interface Student extends Person {
    /**
     * Returns the value of the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>ID</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>ID</em>' attribute.
     * @see #setID(int)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getStudent_ID()
     * @model
     * @generated
     */
    int getID();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Student#getID <em>ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>ID</em>' attribute.
     * @see #getID()
     * @generated
     */
    void setID(int value);

    /**
     * Returns the value of the '<em><b>GPA</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>GPA</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>GPA</em>' attribute.
     * @see #setGPA(double)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getStudent_GPA()
     * @model
     * @generated
     */
    double getGPA();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Student#getGPA <em>GPA</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>GPA</em>' attribute.
     * @see #getGPA()
     * @generated
     */
    void setGPA(double value);

    /**
     * Returns the value of the '<em><b>Enrolled In</b></em>' reference list.
     * The list contents are of type {@link ca.twu.cmpt166.seanho.StudentDB.Course}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enrolled In</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enrolled In</em>' reference list.
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getStudent_EnrolledIn()
     * @model
     * @generated
     */
    EList<Course> getEnrolledIn();

} // Student
