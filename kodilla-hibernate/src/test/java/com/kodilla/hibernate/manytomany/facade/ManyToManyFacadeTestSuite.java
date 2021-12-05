package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ManyToManyFacadeTestSuite {

    @Autowired
    private ManyToManyFacade manyToManyFacade;

    @Test
    public void testCompaniesNameLike() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");
        manyToManyFacade.addCompany(softwareMachine);
        manyToManyFacade.addCompany(dataMaesters);
        manyToManyFacade.addCompany(greyMatter);

        //When
        List<Company> result = manyToManyFacade.findCompaniesWithNameLike("%Soft%");

        //Then
        assertEquals(1, result.size());

        //CleanUp
        try {
            manyToManyFacade.deleteCompanies();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testEmployeesNameLike() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        manyToManyFacade.addEmployee(johnSmith);
        manyToManyFacade.addEmployee(stephanieClarckson);
        manyToManyFacade.addEmployee(lindaKovalsky);

        //When
        List<Employee> result = manyToManyFacade.findEmployeesWithNameLike("%larc%");

        //Then
        assertEquals(1, result.size());

        //CleanUp
        try {
            manyToManyFacade.deleteEmployees();
        } catch (Exception e) {
            // do nothing
        }
    }
}
