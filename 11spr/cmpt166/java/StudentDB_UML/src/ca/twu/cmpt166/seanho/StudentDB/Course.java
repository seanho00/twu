/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ca.twu.cmpt166.seanho.StudentDB;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Course</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Course#getDept <em>Dept</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Course#getNum <em>Num</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Course#getTaughtBy <em>Taught By</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Course#getLocatedAt <em>Located At</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getCourse()
 * @model
 * @generated
 */
public interface Course extends EObject {
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
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getCourse_Dept()
     * @model
     * @generated
     */
    String getDept();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Course#getDept <em>Dept</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dept</em>' attribute.
     * @see #getDept()
     * @generated
     */
    void setDept(String value);

    /**
     * Returns the value of the '<em><b>Num</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Num</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Num</em>' attribute.
     * @see #setNum(int)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getCourse_Num()
     * @model
     * @generated
     */
    int getNum();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Course#getNum <em>Num</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Num</em>' attribute.
     * @see #getNum()
     * @generated
     */
    void setNum(int value);

    /**
     * Returns the value of the '<em><b>Taught By</b></em>' reference list.
     * The list contents are of type {@link ca.twu.cmpt166.seanho.StudentDB.Faculty}.
     * It is bidirectional and its opposite is '{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getTeaches <em>Teaches</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Taught By</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Taught By</em>' reference list.
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getCourse_TaughtBy()
     * @see ca.twu.cmpt166.seanho.StudentDB.Faculty#getTeaches
     * @model opposite="teaches" required="true" upper="2"
     * @generated
     */
    EList<Faculty> getTaughtBy();

    /**
     * Returns the value of the '<em><b>Located At</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Located At</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Located At</em>' reference.
     * @see #setLocatedAt(Room)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getCourse_LocatedAt()
     * @model required="true"
     * @generated
     */
    Room getLocatedAt();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Course#getLocatedAt <em>Located At</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Located At</em>' reference.
     * @see #getLocatedAt()
     * @generated
     */
    void setLocatedAt(Room value);

} // Course
