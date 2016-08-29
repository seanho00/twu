/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ca.twu.cmpt166.seanho.StudentDB.impl;

import ca.twu.cmpt166.seanho.StudentDB.Course;
import ca.twu.cmpt166.seanho.StudentDB.Faculty;
import ca.twu.cmpt166.seanho.StudentDB.Room;
import ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Faculty</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.FacultyImpl#getDept <em>Dept</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.FacultyImpl#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.FacultyImpl#getTeaches <em>Teaches</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.FacultyImpl#getOffice <em>Office</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacultyImpl extends PersonImpl implements Faculty {
    /**
     * The default value of the '{@link #getDept() <em>Dept</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDept()
     * @generated
     * @ordered
     */
    protected static final String DEPT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDept() <em>Dept</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDept()
     * @generated
     * @ordered
     */
    protected String dept = DEPT_EDEFAULT;

    /**
     * The cached value of the '{@link #getEReference0() <em>EReference0</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEReference0()
     * @generated
     * @ordered
     */
    protected Course eReference0;

    /**
     * The cached value of the '{@link #getTeaches() <em>Teaches</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTeaches()
     * @generated
     * @ordered
     */
    protected EList<Course> teaches;

    /**
     * The cached value of the '{@link #getOffice() <em>Office</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOffice()
     * @generated
     * @ordered
     */
    protected Room office;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FacultyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return StudentDBPackage.Literals.FACULTY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDept() {
        return dept;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDept(String newDept) {
        String oldDept = dept;
        dept = newDept;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.FACULTY__DEPT, oldDept, dept));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Course getEReference0() {
        if (eReference0 != null && eReference0.eIsProxy()) {
            InternalEObject oldEReference0 = (InternalEObject)eReference0;
            eReference0 = (Course)eResolveProxy(oldEReference0);
            if (eReference0 != oldEReference0) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, StudentDBPackage.FACULTY__EREFERENCE0, oldEReference0, eReference0));
            }
        }
        return eReference0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Course basicGetEReference0() {
        return eReference0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEReference0(Course newEReference0) {
        Course oldEReference0 = eReference0;
        eReference0 = newEReference0;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.FACULTY__EREFERENCE0, oldEReference0, eReference0));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Course> getTeaches() {
        if (teaches == null) {
            teaches = new EObjectWithInverseResolvingEList.ManyInverse<Course>(Course.class, this, StudentDBPackage.FACULTY__TEACHES, StudentDBPackage.COURSE__TAUGHT_BY);
        }
        return teaches;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Room getOffice() {
        if (office != null && office.eIsProxy()) {
            InternalEObject oldOffice = (InternalEObject)office;
            office = (Room)eResolveProxy(oldOffice);
            if (office != oldOffice) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, StudentDBPackage.FACULTY__OFFICE, oldOffice, office));
            }
        }
        return office;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Room basicGetOffice() {
        return office;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOffice(Room newOffice) {
        Room oldOffice = office;
        office = newOffice;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.FACULTY__OFFICE, oldOffice, office));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case StudentDBPackage.FACULTY__TEACHES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTeaches()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case StudentDBPackage.FACULTY__TEACHES:
                return ((InternalEList<?>)getTeaches()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case StudentDBPackage.FACULTY__DEPT:
                return getDept();
            case StudentDBPackage.FACULTY__EREFERENCE0:
                if (resolve) return getEReference0();
                return basicGetEReference0();
            case StudentDBPackage.FACULTY__TEACHES:
                return getTeaches();
            case StudentDBPackage.FACULTY__OFFICE:
                if (resolve) return getOffice();
                return basicGetOffice();
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
            case StudentDBPackage.FACULTY__DEPT:
                setDept((String)newValue);
                return;
            case StudentDBPackage.FACULTY__EREFERENCE0:
                setEReference0((Course)newValue);
                return;
            case StudentDBPackage.FACULTY__TEACHES:
                getTeaches().clear();
                getTeaches().addAll((Collection<? extends Course>)newValue);
                return;
            case StudentDBPackage.FACULTY__OFFICE:
                setOffice((Room)newValue);
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
            case StudentDBPackage.FACULTY__DEPT:
                setDept(DEPT_EDEFAULT);
                return;
            case StudentDBPackage.FACULTY__EREFERENCE0:
                setEReference0((Course)null);
                return;
            case StudentDBPackage.FACULTY__TEACHES:
                getTeaches().clear();
                return;
            case StudentDBPackage.FACULTY__OFFICE:
                setOffice((Room)null);
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
            case StudentDBPackage.FACULTY__DEPT:
                return DEPT_EDEFAULT == null ? dept != null : !DEPT_EDEFAULT.equals(dept);
            case StudentDBPackage.FACULTY__EREFERENCE0:
                return eReference0 != null;
            case StudentDBPackage.FACULTY__TEACHES:
                return teaches != null && !teaches.isEmpty();
            case StudentDBPackage.FACULTY__OFFICE:
                return office != null;
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
        result.append(" (dept: ");
        result.append(dept);
        result.append(')');
        return result.toString();
    }

} //FacultyImpl
