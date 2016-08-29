/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ca.twu.cmpt166.seanho.StudentDB;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ca.twu.cmpt166.seanho.StudentDB.StudentDBFactory
 * @model kind="package"
 * @generated
 */
public interface StudentDBPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "StudentDB";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://StudentDB/1.0";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "StudentDB";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    StudentDBPackage eINSTANCE = ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl.init();

    /**
     * The meta object id for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.PersonImpl <em>Person</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.PersonImpl
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getPerson()
     * @generated
     */
    int PERSON = 0;

    /**
     * The feature id for the '<em><b>Email</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSON__EMAIL = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSON__NAME = 1;

    /**
     * The number of structural features of the '<em>Person</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSON_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.StudentImpl <em>Student</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentImpl
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getStudent()
     * @generated
     */
    int STUDENT = 1;

    /**
     * The feature id for the '<em><b>Email</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__EMAIL = PERSON__EMAIL;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__NAME = PERSON__NAME;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__ID = PERSON_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>GPA</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__GPA = PERSON_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Enrolled In</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT__ENROLLED_IN = PERSON_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Student</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STUDENT_FEATURE_COUNT = PERSON_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.FacultyImpl <em>Faculty</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.FacultyImpl
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getFaculty()
     * @generated
     */
    int FACULTY = 2;

    /**
     * The feature id for the '<em><b>Email</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FACULTY__EMAIL = PERSON__EMAIL;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FACULTY__NAME = PERSON__NAME;

    /**
     * The feature id for the '<em><b>Dept</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FACULTY__DEPT = PERSON_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>EReference0</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FACULTY__EREFERENCE0 = PERSON_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Teaches</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FACULTY__TEACHES = PERSON_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Office</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FACULTY__OFFICE = PERSON_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Faculty</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FACULTY_FEATURE_COUNT = PERSON_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.CourseImpl <em>Course</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.CourseImpl
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getCourse()
     * @generated
     */
    int COURSE = 3;

    /**
     * The feature id for the '<em><b>Dept</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COURSE__DEPT = 0;

    /**
     * The feature id for the '<em><b>Num</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COURSE__NUM = 1;

    /**
     * The feature id for the '<em><b>Taught By</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COURSE__TAUGHT_BY = 2;

    /**
     * The feature id for the '<em><b>Located At</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COURSE__LOCATED_AT = 3;

    /**
     * The number of structural features of the '<em>Course</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COURSE_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.RoomImpl <em>Room</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.RoomImpl
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getRoom()
     * @generated
     */
    int ROOM = 4;

    /**
     * The feature id for the '<em><b>Building</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOM__BUILDING = 0;

    /**
     * The feature id for the '<em><b>Num</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOM__NUM = 1;

    /**
     * The number of structural features of the '<em>Room</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOM_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '<em>Email Address</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see javax.mail.Address
     * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getEmailAddress()
     * @generated
     */
    int EMAIL_ADDRESS = 5;


    /**
     * Returns the meta object for class '{@link ca.twu.cmpt166.seanho.StudentDB.Person <em>Person</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Person</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Person
     * @generated
     */
    EClass getPerson();

    /**
     * Returns the meta object for the attribute '{@link ca.twu.cmpt166.seanho.StudentDB.Person#getEmail <em>Email</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Email</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Person#getEmail()
     * @see #getPerson()
     * @generated
     */
    EAttribute getPerson_Email();

    /**
     * Returns the meta object for the attribute '{@link ca.twu.cmpt166.seanho.StudentDB.Person#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Person#getName()
     * @see #getPerson()
     * @generated
     */
    EAttribute getPerson_Name();

    /**
     * Returns the meta object for class '{@link ca.twu.cmpt166.seanho.StudentDB.Student <em>Student</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Student</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Student
     * @generated
     */
    EClass getStudent();

    /**
     * Returns the meta object for the attribute '{@link ca.twu.cmpt166.seanho.StudentDB.Student#getID <em>ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>ID</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Student#getID()
     * @see #getStudent()
     * @generated
     */
    EAttribute getStudent_ID();

    /**
     * Returns the meta object for the attribute '{@link ca.twu.cmpt166.seanho.StudentDB.Student#getGPA <em>GPA</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>GPA</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Student#getGPA()
     * @see #getStudent()
     * @generated
     */
    EAttribute getStudent_GPA();

    /**
     * Returns the meta object for the reference list '{@link ca.twu.cmpt166.seanho.StudentDB.Student#getEnrolledIn <em>Enrolled In</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Enrolled In</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Student#getEnrolledIn()
     * @see #getStudent()
     * @generated
     */
    EReference getStudent_EnrolledIn();

    /**
     * Returns the meta object for class '{@link ca.twu.cmpt166.seanho.StudentDB.Faculty <em>Faculty</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Faculty</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Faculty
     * @generated
     */
    EClass getFaculty();

    /**
     * Returns the meta object for the attribute '{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getDept <em>Dept</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dept</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Faculty#getDept()
     * @see #getFaculty()
     * @generated
     */
    EAttribute getFaculty_Dept();

    /**
     * Returns the meta object for the reference '{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getEReference0 <em>EReference0</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>EReference0</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Faculty#getEReference0()
     * @see #getFaculty()
     * @generated
     */
    EReference getFaculty_EReference0();

    /**
     * Returns the meta object for the reference list '{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getTeaches <em>Teaches</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Teaches</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Faculty#getTeaches()
     * @see #getFaculty()
     * @generated
     */
    EReference getFaculty_Teaches();

    /**
     * Returns the meta object for the reference '{@link ca.twu.cmpt166.seanho.StudentDB.Faculty#getOffice <em>Office</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Office</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Faculty#getOffice()
     * @see #getFaculty()
     * @generated
     */
    EReference getFaculty_Office();

    /**
     * Returns the meta object for class '{@link ca.twu.cmpt166.seanho.StudentDB.Course <em>Course</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Course</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Course
     * @generated
     */
    EClass getCourse();

    /**
     * Returns the meta object for the attribute '{@link ca.twu.cmpt166.seanho.StudentDB.Course#getDept <em>Dept</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dept</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Course#getDept()
     * @see #getCourse()
     * @generated
     */
    EAttribute getCourse_Dept();

    /**
     * Returns the meta object for the attribute '{@link ca.twu.cmpt166.seanho.StudentDB.Course#getNum <em>Num</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Num</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Course#getNum()
     * @see #getCourse()
     * @generated
     */
    EAttribute getCourse_Num();

    /**
     * Returns the meta object for the reference list '{@link ca.twu.cmpt166.seanho.StudentDB.Course#getTaughtBy <em>Taught By</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Taught By</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Course#getTaughtBy()
     * @see #getCourse()
     * @generated
     */
    EReference getCourse_TaughtBy();

    /**
     * Returns the meta object for the reference '{@link ca.twu.cmpt166.seanho.StudentDB.Course#getLocatedAt <em>Located At</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Located At</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Course#getLocatedAt()
     * @see #getCourse()
     * @generated
     */
    EReference getCourse_LocatedAt();

    /**
     * Returns the meta object for class '{@link ca.twu.cmpt166.seanho.StudentDB.Room <em>Room</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Room</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Room
     * @generated
     */
    EClass getRoom();

    /**
     * Returns the meta object for the attribute '{@link ca.twu.cmpt166.seanho.StudentDB.Room#getBuilding <em>Building</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Building</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Room#getBuilding()
     * @see #getRoom()
     * @generated
     */
    EAttribute getRoom_Building();

    /**
     * Returns the meta object for the attribute '{@link ca.twu.cmpt166.seanho.StudentDB.Room#getNum <em>Num</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Num</em>'.
     * @see ca.twu.cmpt166.seanho.StudentDB.Room#getNum()
     * @see #getRoom()
     * @generated
     */
    EAttribute getRoom_Num();

    /**
     * Returns the meta object for data type '{@link javax.mail.Address <em>Email Address</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Email Address</em>'.
     * @see javax.mail.Address
     * @model instanceClass="javax.mail.Address"
     * @generated
     */
    EDataType getEmailAddress();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    StudentDBFactory getStudentDBFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.PersonImpl <em>Person</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.PersonImpl
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getPerson()
         * @generated
         */
        EClass PERSON = eINSTANCE.getPerson();

        /**
         * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PERSON__EMAIL = eINSTANCE.getPerson_Email();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PERSON__NAME = eINSTANCE.getPerson_Name();

        /**
         * The meta object literal for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.StudentImpl <em>Student</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentImpl
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getStudent()
         * @generated
         */
        EClass STUDENT = eINSTANCE.getStudent();

        /**
         * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STUDENT__ID = eINSTANCE.getStudent_ID();

        /**
         * The meta object literal for the '<em><b>GPA</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STUDENT__GPA = eINSTANCE.getStudent_GPA();

        /**
         * The meta object literal for the '<em><b>Enrolled In</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STUDENT__ENROLLED_IN = eINSTANCE.getStudent_EnrolledIn();

        /**
         * The meta object literal for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.FacultyImpl <em>Faculty</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.FacultyImpl
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getFaculty()
         * @generated
         */
        EClass FACULTY = eINSTANCE.getFaculty();

        /**
         * The meta object literal for the '<em><b>Dept</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FACULTY__DEPT = eINSTANCE.getFaculty_Dept();

        /**
         * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FACULTY__EREFERENCE0 = eINSTANCE.getFaculty_EReference0();

        /**
         * The meta object literal for the '<em><b>Teaches</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FACULTY__TEACHES = eINSTANCE.getFaculty_Teaches();

        /**
         * The meta object literal for the '<em><b>Office</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FACULTY__OFFICE = eINSTANCE.getFaculty_Office();

        /**
         * The meta object literal for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.CourseImpl <em>Course</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.CourseImpl
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getCourse()
         * @generated
         */
        EClass COURSE = eINSTANCE.getCourse();

        /**
         * The meta object literal for the '<em><b>Dept</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COURSE__DEPT = eINSTANCE.getCourse_Dept();

        /**
         * The meta object literal for the '<em><b>Num</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COURSE__NUM = eINSTANCE.getCourse_Num();

        /**
         * The meta object literal for the '<em><b>Taught By</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COURSE__TAUGHT_BY = eINSTANCE.getCourse_TaughtBy();

        /**
         * The meta object literal for the '<em><b>Located At</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COURSE__LOCATED_AT = eINSTANCE.getCourse_LocatedAt();

        /**
         * The meta object literal for the '{@link ca.twu.cmpt166.seanho.StudentDB.impl.RoomImpl <em>Room</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.RoomImpl
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getRoom()
         * @generated
         */
        EClass ROOM = eINSTANCE.getRoom();

        /**
         * The meta object literal for the '<em><b>Building</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ROOM__BUILDING = eINSTANCE.getRoom_Building();

        /**
         * The meta object literal for the '<em><b>Num</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ROOM__NUM = eINSTANCE.getRoom_Num();

        /**
         * The meta object literal for the '<em>Email Address</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see javax.mail.Address
         * @see ca.twu.cmpt166.seanho.StudentDB.impl.StudentDBPackageImpl#getEmailAddress()
         * @generated
         */
        EDataType EMAIL_ADDRESS = eINSTANCE.getEmailAddress();

    }

} //StudentDBPackage
