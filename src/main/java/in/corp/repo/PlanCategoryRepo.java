package in.corp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.corp.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory,Integer> {

}
