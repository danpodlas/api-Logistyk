package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Role;
import pl.podlaski.api.Repo.RoleRepo;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleService {
    private RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role findByName(String name){
        return roleRepo.findByName(name);
    }

}
