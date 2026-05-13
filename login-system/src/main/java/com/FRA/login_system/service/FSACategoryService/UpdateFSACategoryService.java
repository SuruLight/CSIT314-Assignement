package com.FRA.login_system.service.FSACategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.FSACategory;
import com.FRA.login_system.repository.FSACategoryRepository;

@Service
public class UpdateFSACategoryService {

    @Autowired
    private FSACategoryRepository fsaCategoryRepository;

    public String updateFSACategory(int categoryID, String categoryName, String categoryDescription) {

        FSACategory category = fsaCategoryRepository.findById(categoryID).orElse(null);

        if (category == null || categoryName == null || categoryName.isEmpty()) {
            return "Failed to update FSA Category. Please check and try again.";
        }

        String result = category.updateFSACategory(categoryID, categoryName,categoryDescription);

        fsaCategoryRepository.save(category);

        return result;
    }
}