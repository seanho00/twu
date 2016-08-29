/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ca.twu.cmpt166.seanho.StudentDB;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Room</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Room#getBuilding <em>Building</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.Room#getNum <em>Num</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getRoom()
 * @model
 * @generated
 */
public interface Room extends EObject {
    /**
     * Returns the value of the '<em><b>Building</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Building</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Building</em>' attribute.
     * @see #setBuilding(String)
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getRoom_Building()
     * @model
     * @generated
     */
    String getBuilding();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Room#getBuilding <em>Building</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Building</em>' attribute.
     * @see #getBuilding()
     * @generated
     */
    void setBuilding(String value);

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
     * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage#getRoom_Num()
     * @model
     * @generated
     */
    int getNum();

    /**
     * Sets the value of the '{@link ca.twu.cmpt166.seanho.StudentDB.Room#getNum <em>Num</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Num</em>' attribute.
     * @see #getNum()
     * @generated
     */
    void setNum(int value);

} // Room
