package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManyToManyFacade {

    // private static final Logger LOGGER = LoggerFactory.getLogger(ManyToManyFacade.class);

    private List<Company> facadeCompanies = new ArrayList<>();
    private List<Employee> facadeEmployees = new ArrayList<>();

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public ManyToManyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public void addCompany(Company company) {
        companyDao.save(company);
        facadeCompanies.add(company);
    }

    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
        facadeEmployees.add(employee);
    }

    public void deleteCompanies() {
        for (Company company : facadeCompanies) {
            companyDao.deleteById(company.getId());
        }
    }

    public void deleteEmployees() {
        for (Employee employee : facadeEmployees) {
            employeeDao.deleteById(employee.getId());
        }
    }

    public List<Company> findCompaniesWithNameLike(String nameLike) {
        return companyDao.retrieveCompaniesWithNameLike(nameLike);
    }

    public List<Employee> findEmployeesWithNameLike(String lastNameLike) {
        return employeeDao.retrieveEmployeesWithNameLike(lastNameLike);
    }
}
