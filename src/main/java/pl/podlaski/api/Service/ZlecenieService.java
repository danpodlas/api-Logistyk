package pl.podlaski.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.podlaski.api.DAO.Entity.Zlecenie;
import pl.podlaski.api.Repo.ZleceniaRepo;

import java.util.List;

@Service
public class ZlecenieService {
    private ZleceniaRepo zleceniaRepo;

    @Autowired
    public ZlecenieService(ZleceniaRepo zleceniaRepo) {
        this.zleceniaRepo = zleceniaRepo;
    }

    public List<Zlecenie> findAll() {
        return zleceniaRepo.findAll();
    }

    public Zlecenie findOne(long id) {
        return zleceniaRepo.getOne(id);
    }

    public Zlecenie findId(long id) {
        return zleceniaRepo.findById(id);
    }

    public List<Zlecenie> findByStatus(String s) {
        return zleceniaRepo.findZlecenieByStatus(s);
    }

    public Zlecenie save(Zlecenie zlecenie) {
        return zleceniaRepo.save(zlecenie);
    }

    public Zlecenie update(Zlecenie zlecenie) {
        return zleceniaRepo.saveAndFlush(zlecenie);
    }

    public void delete(long id) {
        zleceniaRepo.deleteById(id);
    }

    public List<Zlecenie> findKlientById(long s) {
        return zleceniaRepo.findZlecenieByKlient_id(s);
    }
}
