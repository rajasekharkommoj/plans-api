package in.corp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.corp.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan,Integer> {

}
