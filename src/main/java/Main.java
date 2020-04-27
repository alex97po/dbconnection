import com.pogorelov.dbconnection.domain.Department;
import com.pogorelov.dbconnection.service.ServiceFactory;


public class Main {

    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public static void main(String[] args) {
//        Department department = new Department();
//        department.setId(3L);
//        department.setName("Management");
//        serviceFactory.getDepartmentService().updateDepartment(department);
//        serviceFactory.getDepartmentService().deleteDepartment(4L);
//        System.out.println(serviceFactory.getDepartmentService().getAllDepartments());
//
//        System.out.println(serviceFactory.getDepartmentService().findDepartmentByName("IT"));

        Department department = new Department();
        serviceFactory.getDepartmentService().createDepartment(department);
        department.setId(3L);
        department.setName("Test");
        serviceFactory.getDepartmentService().updateDepartment(department);
        System.out.println(serviceFactory.getDepartmentService().findDepartmentById(3L));
        serviceFactory.getDepartmentService().deleteDepartment(3L);
        System.out.println(serviceFactory.getDepartmentService().getAllDepartments());
    }


}
