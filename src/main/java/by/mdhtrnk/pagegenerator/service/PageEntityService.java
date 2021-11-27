package by.mdhtrnk.pagegenerator.service;

import by.mdhtrnk.pagegenerator.entity.PageEntity;
import by.mdhtrnk.pagegenerator.repository.PageEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PageEntityService implements BaseService<PageEntity> {

    private final PageEntityRepository pageEntityRepository;

    @Autowired
    public PageEntityService(PageEntityRepository pageEntityRepository) {
        this.pageEntityRepository = pageEntityRepository;
    }

    @Override
    public List<PageEntity> findAll() {
        return pageEntityRepository.findAllByOrderByPriorityAsc();
    }

    @Override
    public PageEntity save(PageEntity pageEntity) {
        String modifiedSlug = pageEntity.getSlug().replace(" ", "_");
        pageEntity.setSlug(modifiedSlug);
        return pageEntityRepository.saveAndFlush(pageEntity);
    }



    @Override
    public PageEntity findById(Long id) {
        Optional<PageEntity> pageEntity = pageEntityRepository.findById(id);
        if (pageEntity.isPresent()){
            return pageEntity.get();
        } else {
            throw new RuntimeException("No such page exists");
        }
    }

    @Override
    public void deleteById(Long id) {
        pageEntityRepository.deleteById(id);
    }

    public PageEntity findBySlug(String slug){
        Optional<PageEntity> pageEntity = pageEntityRepository.findBySlug(slug);
        if (pageEntity.isPresent()){
            return pageEntity.get();
        } else {
            throw new RuntimeException("No such page exists");
        }
    }
}
