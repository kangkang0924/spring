package com.spring.service.impl;

import com.spring.dao.MedicineDAO;
import com.spring.service.MedicineService;

/**
 * @author ablaze
 * @Date: 2023/10/23/15:34
 */
public class MedicineServiceImpl implements MedicineService {

    private MedicineDAO medicineDAO;

    public void setMedicineDAO(MedicineDAO medicineDAO) {
        this.medicineDAO = medicineDAO;
    }
}
