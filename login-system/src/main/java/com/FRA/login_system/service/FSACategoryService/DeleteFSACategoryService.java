package com.FRA.login_system.service.FSACategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FRA.login_system.entity.FSACategory;
import com.FRA.login_system.repository.FSACategoryRepository;

@Service
public class DeleteFSACategoryService {

    @Autowired
    private FSACategoryRepository fsaCategoryRepository;

    public String deleteFSACategory(int categoryID) {

        FSACategory category = fsaCategoryRepository.findById(categoryID).orElse(null);

        if (category == null) {
            return "Failed to delete FSA Category. Please check and try again.";
        }

        String result = category.deleteFSACategory(categoryID);

        fsaCategoryRepository.delete(category);

        return result;
    }
}