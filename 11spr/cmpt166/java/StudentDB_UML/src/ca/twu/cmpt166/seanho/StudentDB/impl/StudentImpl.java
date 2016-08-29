/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ca.twu.cmpt166.seanho.StudentDB.impl;

import ca.twu.cmpt166.seanho.StudentDB.Course;
import ca.twu.cmpt166.seanho.StudentDB.Student;
import ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Student</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.StudentImpl#getID <em>ID</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.StudentImpl#getGPA <em>GPA</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.StudentImpl#getEnrolledIn <em>Enrolled In</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StudentImpl extends PersonImpl implements Student {
    /**
     * The default value of the '{@link #getID() <em>ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getID()
     * @generated
     * @ordered
     */
    protected static final int ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getID()
     * @generated
     * @ordered
     */
    protected int id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getGPA() <em>GPA</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGPA()
     * @generated
     * @ordered
     */
    protected static final double GPA_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getGPA() <em>GPA</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGPA()
     * @generated
     * @ordered
     */
    protected double gpa = GPA_EDEFAULT;

    /**
     * The cached value of the '{@link #getEnrolledIn() <em>Enrolled In</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnrolledIn()
     * @generated
     * @ordered
     */
    protected EList<Course> enrolledIn;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StudentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return StudentDBPackage.Literals.STUDENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getID() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setID(int newID) {
        int oldID = id;
        id = newID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.STUDENT__ID, oldID, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getGPA() {
        return gpa;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGPA(double newGPA) {
        double oldGPA = gpa;
        gpa = newGPA;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.STUDENT__GPA, oldGPA, gpa));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Course> getEnrolledIn() {
        if (enrolledIn == null) {
            enrolledIn = new EObjectResolvingEList<Course>(Course.class, this, StudentDBPackage.STUDENT__ENROLLED_IN);
        }
        return enrolledIn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case StudentDBPackage.STUDENT__ID:
                return getID();
            case StudentDBPackage.STUDENT__GPA:
                return getGPA();
            case StudentDBPackage.STUDENT__ENROLLED_IN:
                return getEnrolledIn();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case StudentDBPackage.STUDENT__ID:
                setID((Integer)newValue);
                return;
            case StudentDBPackage.STUDENT__GPA:
                setGPA((Double)newValue);
                return;
            case StudentDBPackage.STUDENT__ENROLLED_IN:
                getEnrolledIn().clear();
                getEnrolledIn().addAll((Collection<? extends Course>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case StudentDBPackage.STUDENT__ID:
                setID(ID_EDEFAULT);
                return;
            case StudentDBPackage.STUDENT__GPA:
                setGPA(GPA_EDEFAULT);
                return;
            case StudentDBPackage.STUDENT__ENROLLED_IN:
                getEnrolledIn().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case StudentDBPackage.STUDENT__ID:
                return id != ID_EDEFAULT;
            case StudentDBPackage.STUDENT__GPA:
                return gpa != GPA_EDEFAULT;
            case StudentDBPackage.STUDENT__ENROLLED_IN:
                return enrolledIn != null && !enrolledIn.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (ID: ");
        result.append(id);
        result.append(", GPA: ");
        result.append(gpa);
        result.append(')');
        return result.toString();
    }

} //StudentImpl
