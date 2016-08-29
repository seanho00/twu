/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ca.twu.cmpt166.seanho.StudentDB.impl;

import ca.twu.cmpt166.seanho.StudentDB.Room;
import ca.twu.cmpt166.seanho.StudentDB.StudentDBPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Room</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.RoomImpl#getBuilding <em>Building</em>}</li>
 *   <li>{@link ca.twu.cmpt166.seanho.StudentDB.impl.RoomImpl#getNum <em>Num</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoomImpl extends EObjectImpl implements Room {
    /**
     * The default value of the '{@link #getBuilding() <em>Building</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuilding()
     * @generated
     * @ordered
     */
    protected static final String BUILDING_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBuilding() <em>Building</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuilding()
     * @generated
     * @ordered
     */
    protected String building = BUILDING_EDEFAULT;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RoomImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return StudentDBPackage.Literals.ROOM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBuilding() {
        return building;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBuilding(String newBuilding) {
        String oldBuilding = building;
        building = newBuilding;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.ROOM__BUILDING, oldBuilding, building));
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
            eNotify(new ENotificationImpl(this, Notification.SET, StudentDBPackage.ROOM__NUM, oldNum, num));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case StudentDBPackage.ROOM__BUILDING:
                return getBuilding();
            case StudentDBPackage.ROOM__NUM:
                return getNum();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case StudentDBPackage.ROOM__BUILDING:
                setBuilding((String)newValue);
                return;
            case StudentDBPackage.ROOM__NUM:
                setNum((Integer)newValue);
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
            case StudentDBPackage.ROOM__BUILDING:
                setBuilding(BUILDING_EDEFAULT);
                return;
            case StudentDBPackage.ROOM__NUM:
                setNum(NUM_EDEFAULT);
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
            case StudentDBPackage.ROOM__BUILDING:
                return BUILDING_EDEFAULT == null ? building != null : !BUILDING_EDEFAULT.equals(building);
            case StudentDBPackage.ROOM__NUM:
                return num != NUM_EDEFAULT;
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
        result.append(" (building: ");
        result.append(building);
        result.append(", num: ");
        result.append(num);
        result.append(')');
        return result.toString();
    }

} //RoomImpl
