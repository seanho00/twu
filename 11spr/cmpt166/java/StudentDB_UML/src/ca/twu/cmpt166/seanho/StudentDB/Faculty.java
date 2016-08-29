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
 * A representation of the model object '<em><b>Faculty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getDept <em>Dept</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getTeaches <em>Teaches</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getOffice <em>Office</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getFaculty()
 * @model
 * @generated
 */
public interface Faculty extends Person {
    /**
     * Returns the value of the '<em><b>Dept</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dept</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dept</em>' attribute.
     * @see #setDept(String)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getFaculty_Dept()
     * @model
     * @generated
     */
    String getDept();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getDept <em>Dept</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dept</em>' attribute.
     * @see #getDept()
     * @generated
     */
    void setDept(String value);

    /**
     * Returns the value of the '<em><b>EReference0</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>EReference0</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>EReference0</em>' reference.
     * @see #setEReference0(Course)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getFaculty_EReference0()
     * @model
     * @generated
     */
    Course getEReference0();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getEReference0 <em>EReference0</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>EReference0</em>' reference.
     * @see #getEReference0()
     * @generated
     */
    void setEReference0(Course value);

    /**
     * Returns the value of the '<em><b>Teaches</b></em>' reference list.
     * The list contents are of type {@link ca.twu.cmpt166.seanho.StudentDB.Course}.
     * It is bidirectional and its opposite is '{@link ca.twu.cmpt166.seanho.StudentDB.Course#getTaughtBy <em>Taught By</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Teaches</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Teaches</em>' reference list.
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getFaculty_Teaches()
     * @see ca.twu.cmpt166.seanho.StudentDB.Course#getTaughtBy
     * @model opposite="taughtBy"
     * @generated
     */
    EList<Course> getTeaches();

    /**
     * Returns the value of the '<em><b>Office</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Office</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Office</em>' reference.
     * @see #setOffice(Room)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getFaculty_Office()
     * @model required="true"
     * @generated
     */
    Room getOffice();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getOffice <em>Office</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Office</em>' reference.
     * @see #getOffice()
     * @generated
     */
    void setOffice(Room value);

} // Faculty
