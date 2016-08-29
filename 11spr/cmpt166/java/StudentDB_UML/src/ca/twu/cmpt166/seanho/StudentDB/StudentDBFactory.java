/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ca.twu.cmpt166.seanho.StudentDB;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage
 * @generated
 */
public interface StudentDBFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    StudentDBFactory eINSTANCE = ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Student</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Student</em>'.
     * @generated
     */
    Student createStudent();

    /**
     * Returns a new object of class '<em>Faculty</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Faculty</em>'.
     * @generated
     */
    Faculty createFaculty();

    /**
     * Returns a new object of class '<em>Course</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Course</em>'.
     * @generated
     */
    Course createCourse();

    /**
     * Returns a new object of class '<em>Room</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Room</em>'.
     * @generated
     */
    Room createRoom();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    StudentDBPackage getStudentDBPackage();

} //StudentDBFactory
