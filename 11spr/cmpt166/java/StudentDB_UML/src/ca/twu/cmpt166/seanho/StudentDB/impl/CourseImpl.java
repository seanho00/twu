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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Course</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.CourseImpl#getDept <em>Dept</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.CourseImpl#getNum <em>Num</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.CourseImpl#getTaughtBy <em>Taught By</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.CourseImpl#getLocatedAt <em>Located At</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CourseImpl extends EObjectImpl implements Course {
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
     * The default value of the '{@link #getNum() <em>Num</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNum()
     * @generated
     * @ordered
     */
    protected static final int NUM_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getNum() <em>Num</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNum()
     * @generated
     * @ordered
     */
    protected int num = NUM_EDEFAULT;

    /**
     * The cached value of the '{@link #getTaughtBy() <em>Taught By</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTaughtBy()
     * @generated
     * @ordered
     */
    protected EList<Faculty> taughtBy;

    /**
     * The cached value of the '{@link #getLocatedAt() <em>Located At</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocatedAt()
     * @generated
     * @ordered
     */
    protected Room locatedAt;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CourseImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return StudentDBPackage.Literals.COURSE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.COURSE__DEPT, oldDept, dept));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getNum() {
        return num;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNum(int newNum) {
        int oldNum = num;
        num = newNum;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.COURSE__NUM, oldNum, num));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Faculty> getTaughtBy() {
        if (taughtBy == null) {
            taughtBy = new EObjectWithInverseResolvingEList.ManyInverse<Faculty>(Faculty.class, this, StudentDBPackage.COURSE__TAUGHT_BY, StudentDBPackage.FACULTY__TEACHES);
        }
        return taughtBy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Room getLocatedAt() {
        if (locatedAt != null && locatedAt.eIsProxy()) {
            InternalEObject oldLocatedAt = (InternalEObject)locatedAt;
            locatedAt = (Room)eResolveProxy(oldLocatedAt);
            if (locatedAt != oldLocatedAt) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, StudentDBPackage.COURSE__LOCATED_AT, oldLocatedAt, locatedAt));
            }
        }
        return locatedAt;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Room basicGetLocatedAt() {
        return locatedAt;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocatedAt(Room newLocatedAt) {
        Room oldLocatedAt = locatedAt;
        locatedAt = newLocatedAt;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.COURSE__LOCATED_AT, oldLocatedAt, locatedAt));
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
            case StudentDBPackage.COURSE__TAUGHT_BY:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTaughtBy()).basicAdd(otherEnd, msgs);
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
            case StudentDBPackage.COURSE__TAUGHT_BY:
                return ((InternalEList<?>)getTaughtBy()).basicRemove(otherEnd, msgs);
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
            case StudentDBPackage.COURSE__DEPT:
                return getDept();
            case StudentDBPackage.COURSE__NUM:
                return getNum();
            case StudentDBPackage.COURSE__TAUGHT_BY:
                return getTaughtBy();
            case StudentDBPackage.COURSE__LOCATED_AT:
                if (resolve) return getLocatedAt();
                return basicGetLocatedAt();
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
            case StudentDBPackage.COURSE__DEPT:
                setDept((String)newValue);
                return;
            case StudentDBPackage.COURSE__NUM:
                setNum((Integer)newValue);
                return;
            case StudentDBPackage.COURSE__TAUGHT_BY:
                getTaughtBy().clear();
                getTaughtBy().addAll((Collection<? extends Faculty>)newValue);
                return;
            case StudentDBPackage.COURSE__LOCATED_AT:
                setLocatedAt((Room)newValue);
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
            case StudentDBPackage.COURSE__DEPT:
                setDept(DEPT_EDEFAULT);
                return;
            case StudentDBPackage.COURSE__NUM:
                setNum(NUM_EDEFAULT);
                return;
            case StudentDBPackage.COURSE__TAUGHT_BY:
                getTaughtBy().clear();
                return;
            case StudentDBPackage.COURSE__LOCATED_AT:
                setLocatedAt((Room)null);
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
            case StudentDBPackage.COURSE__DEPT:
                return DEPT_EDEFAULT == null ? dept != null : !DEPT_EDEFAULT.equals(dept);
            case StudentDBPackage.COURSE__NUM:
                return num != NUM_EDEFAULT;
            case StudentDBPackage.COURSE__TAUGHT_BY:
                return taughtBy != null && !taughtBy.isEmpty();
            case StudentDBPackage.COURSE__LOCATED_AT:
                return locatedAt != null;
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
        result.append(", num: ");
        result.append(num);
        result.append(')');
        return result.toString();
    }

} //CourseImpl
